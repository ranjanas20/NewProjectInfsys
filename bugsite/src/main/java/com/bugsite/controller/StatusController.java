package com.bugsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugsite.dto.ResponseDTO;
import com.bugsite.dto.StatusDTO;
import com.bugsite.service.StatusService;

@RestController
public class StatusController {
	
    @Autowired
    private StatusService statusService;
    
    @GetMapping(value = "/status")
    public ResponseDTO<List<StatusDTO>>  getBugs() {
        ResponseDTO<List<StatusDTO>> resp = new ResponseDTO<List<StatusDTO>>();
        resp.setData( statusService.findAllStatus());
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp;
    }
    
}
