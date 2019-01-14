package com.bugsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugsite.dto.BugDTO;
import com.bugsite.dto.ResponseDTO;
import com.bugsite.dto.SearchResponseDTO;
import com.bugsite.service.BugService;

@RestController
public class BugController {
	
    @Autowired
    private BugService bugService;
    
    @PostMapping(value = "/bug")
    public ResponseDTO<BugDTO> saveBug(@RequestBody BugDTO dto){
        ResponseDTO<BugDTO> resp = new ResponseDTO<>();
        resp.setData(bugService.addBug(dto));
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp; 
    }
    
    @GetMapping(value = "/pagewisebugs")
    public SearchResponseDTO<BugDTO>  getBugsPageWise(@RequestParam(required = false, defaultValue = "1", value="pageNo") Integer pageNo, 
           @RequestParam(required = false, defaultValue = "20", value="pageSize") Integer pageSize,
           @RequestParam(required = false, defaultValue = "bugId", value="sortField") String sortField,
           @RequestParam(required = false, defaultValue = "ASC", value="sortOrder") String sortOrder) {
    	SearchResponseDTO<BugDTO> resp = new SearchResponseDTO<BugDTO>();
        resp = bugService.findAllBugsPageWise(pageNo,pageSize,sortField,sortOrder);
        resp.setSuccess(true);
        resp.setRespCode("OK");
        resp.setRespMessage("ALL SET");
        resp.setPageNumber(pageNo);
        return resp;
    }
    
    
    @GetMapping(value = "/bugs")
    public ResponseDTO<List<BugDTO>>  getBugs() {
        ResponseDTO<List<BugDTO>> resp = new ResponseDTO<List<BugDTO>>();
        resp.setData( bugService.findAllBugs());
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp;
    }
    
}
