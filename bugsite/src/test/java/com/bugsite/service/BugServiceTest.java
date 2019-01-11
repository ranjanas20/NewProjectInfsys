package com.bugsite.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bugsite.dto.BugDTO;
import com.bugsite.repository.BugRepository;




/**
 * Test Order Service, runs the test in Spring container
 * */

@RunWith(SpringRunner.class)
@SpringBootTest 
@Transactional
public class BugServiceTest {

	@Autowired
	BugService bugService;
	
	@Autowired
	BugRepository repo;
		
	private String title="Functionality";
	private String description="Error while pressing save button";
	private String statusCode="NEW";
	private String importanceCode="MED";
	
	private String title1="Functionality";
	private String description1="Error while pressing delete button";
	private String statusCode1="NEW";
	private String importanceCode1="LOW";
	
	@Before
	public void setUp() throws Exception {
		
		BugDTO bugDTO = new BugDTO();
		bugDTO.setBugId(4L);
		bugDTO.setTitle(title);
		bugDTO.setDescription(description);
		bugDTO.setStatusCode(statusCode);
		bugDTO.setImportanceCode(importanceCode);
		
		bugService.addBug(bugDTO);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testListBugs() {
		List<BugDTO> listOfBugs;
		listOfBugs = bugService.findAllBugs();
		System.out.println("size of listOfBugs" + listOfBugs.size());
		assertTrue(listOfBugs.size()==4);
		assertTrue(listOfBugs.get(3).getTitle().equals(title));
		assertTrue(listOfBugs.get(3).getDescription().equals(description));
	}
	
	@Test
	public void testAddBug() {
		BugDTO bugDTO = new BugDTO();
		bugDTO.setBugId(5L);
		bugDTO.setTitle(title1);
		bugDTO.setDescription(description1);
		bugDTO.setStatusCode(statusCode1);
		bugDTO.setImportanceCode(importanceCode1);
		
		BugDTO dto = bugService.addBug(bugDTO);
			
		assertTrue(dto.getTitle().equals(title1));
		assertTrue(dto.getDescription().equals(description1));
	}


}
