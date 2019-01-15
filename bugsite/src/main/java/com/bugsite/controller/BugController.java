package com.bugsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bugsite.dto.BugDTO;
import com.bugsite.dto.BugsCountDTO;
import com.bugsite.dto.ResponseDTO;
import com.bugsite.dto.BugListResponseDTO;
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
    
    @PutMapping(value = "/bug")
    public ResponseDTO<BugDTO> updateBug(@RequestBody BugDTO dto){
        ResponseDTO<BugDTO> resp = new ResponseDTO<>();
        resp.setData(bugService.updateBug(dto));
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp; 
    }
    
    @GetMapping(value = "/pagewisebugs")
    public BugListResponseDTO<BugDTO>  getBugsPageWise(@RequestParam(required = false, defaultValue = "1", value="pageNo") Integer pageNo, 
           @RequestParam(required = false, defaultValue = "20", value="pageSize") Integer pageSize,
           @RequestParam(required = false, defaultValue = "bugId", value="sortField") String sortField,
           @RequestParam(required = false, defaultValue = "ASC", value="sortOrder") String sortOrder) {
    	BugListResponseDTO<BugDTO> resp = new BugListResponseDTO<BugDTO>();
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
    
    @GetMapping(value = "/bugscount")
    public ResponseDTO<Long>  getBugsCount() {
        ResponseDTO<Long> resp = new ResponseDTO<Long>();
        resp.setData( bugService.getBugsCount());
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp;
    }
    
    @GetMapping(value = "/allbugscount")
    public ResponseDTO<BugsCountDTO>  getAllBugsCount() {
        ResponseDTO<BugsCountDTO> resp = new ResponseDTO<BugsCountDTO>();
        resp.setData( bugService.getAllBugsCount());
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp;
    }
    
}
