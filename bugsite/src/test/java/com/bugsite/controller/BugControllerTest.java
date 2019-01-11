package com.bugsite.controller;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bugsite.BugsiteApplication;
import com.bugsite.dto.BugDTO;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BugsiteApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BugControllerTest {

	@LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private String title="Functionality";
	private String description="Error while pressing save button";
	private String statusCode="NEW";
	private String importanceCode="MED";

	 @Test
    public void addBug() {

        BugDTO bugDTO = new BugDTO();
        bugDTO.setBugId(4L);
		bugDTO.setTitle(title);
		bugDTO.setDescription(description);
		bugDTO.setStatusCode(statusCode);
		bugDTO.setImportanceCode(importanceCode);

        HttpEntity<BugDTO> entity = new HttpEntity<BugDTO>(bugDTO, headers);

        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/bug"), HttpMethod.POST,
                entity, String.class);

        String actual = response.getBody();
        HttpStatus status = response.getStatusCode();
        
        if (HttpStatus.OK != status && HttpStatus.CREATED != status) {
            System.out.println("status " + status);
        }
        
        System.out.println("actual " + actual);
        assertTrue(HttpStatus.OK == status || HttpStatus.CREATED == status);

    }
	 
    @Test
    public void testRetrieveAllBugs() {

    	ResponseEntity<ResponseDTO<List<BugDTO>>> response = restTemplate.exchange(
    			createURLWithPort("/bugs"),
    			HttpMethod.GET,
    			null,
    			new ParameterizedTypeReference<ResponseDTO<List<BugDTO>>>(){});
    	ResponseDTO<List<BugDTO>>  responseDTO = response.getBody();
    	List<BugDTO> listOfBugs = responseDTO.getData();
    	System.out.println("listOfBugs.size:  -->" + listOfBugs.size());
    	
    	assertTrue(listOfBugs.size()==3);
    	//first row of Test data: (1,'Functionality','error displayed while save','NEW','LOW',null,null,null,null);
    	assertTrue(listOfBugs.get(0).getTitle().equals("Functionality"));
		assertTrue(listOfBugs.get(0).getDescription().equals("error displayed while save"));
        
        /*
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/bugs"), HttpMethod.GET,
                entity, String.class);
		System.out.println("response.getBody():  -->" + response.getBody());
        */

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
