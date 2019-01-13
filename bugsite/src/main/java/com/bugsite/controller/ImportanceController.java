package com.bugsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bugsite.dto.ImportanceDTO;
import com.bugsite.dto.ResponseDTO;
import com.bugsite.service.ImportanceService;

@RestController
public class ImportanceController {
	
    @Autowired
    private ImportanceService importanceService;
    
    @GetMapping(value = "/importance")
    public ResponseDTO<List<ImportanceDTO>>  getBugs() {
        ResponseDTO<List<ImportanceDTO>> resp = new ResponseDTO<List<ImportanceDTO>>();
        resp.setData( importanceService.findAllImportance() );
        resp.setSuccess(true);
        resp.setRespCode("200");
        resp.setRespMessage("SUCCESS");
        return resp;
    }
    
}
