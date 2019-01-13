package com.bugsite.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsite.dto.StatusDTO;
import com.bugsite.entity.StatusEntity;
import com.bugsite.repository.StatusRepository;

@Service
public class StatusService {
    
    @Autowired
    private StatusRepository statusRepository;
    
    public List<StatusDTO> findAllStatus() {
    	List<StatusEntity> slist = statusRepository.findAll();
    	return slist.stream()
    			.map(r -> { return toStatusDTO(r);})
    			.collect(Collectors.toList());
    }
    
    public static StatusDTO toStatusDTO(StatusEntity entity){
    	StatusDTO dto = new StatusDTO();
       
    	dto.setStatusCode(entity.getStatusCode());
        dto.setStatusDescription(entity.getStatusDescription());
        
        return dto;
    }
    
}
