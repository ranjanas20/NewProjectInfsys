package com.bugsite.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsite.dto.ImportanceDTO;
import com.bugsite.entity.ImportanceEntity;
import com.bugsite.repository.ImportanceRepository;

@Service
public class ImportanceService {
    
    @Autowired
    private ImportanceRepository importanceRepository;
    
    public List<ImportanceDTO> findAllImportance() {
    	List<ImportanceEntity> slist = importanceRepository.findAll();
    	return slist.stream()
    			.map(r -> { return toImportanceDTO(r);})
    			.collect(Collectors.toList());
    }
    
    public static ImportanceDTO toImportanceDTO(ImportanceEntity entity){
    	ImportanceDTO dto = new ImportanceDTO();
       
    	dto.setImportanceCode(entity.getImpCode());
        dto.setImportanceDescription(entity.getImpDescription());
        
        return dto;
    }
    
}
