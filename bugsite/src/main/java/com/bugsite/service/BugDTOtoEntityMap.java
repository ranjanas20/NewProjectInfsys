package com.bugsite.service;

import com.bugsite.dto.BugDTO;
import com.bugsite.dto.StatusDTO;
import com.bugsite.entity.BugEntity;
import com.bugsite.entity.ImportanceEntity;
import com.bugsite.entity.StatusEntity;

import static com.bugsite.service.DataConvertUtil.*;

import javax.persistence.EntityManager;


public class BugDTOtoEntityMap {

	
    
    
    public static BugEntity updateBugEntity(BugEntity entity, BugDTO dto){
        entity.setBugId(dto.getBugId());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatusEntity(new StatusEntity(dto.getStatusCode()));
        entity.setImportanceEntity(new ImportanceEntity(dto.getImportanceCode()));
        setAuditableMODIFY(entity);
        return entity;
        
    }
    
    public static StatusDTO toStatusDTO(StatusEntity entity){
    	StatusDTO dto = new StatusDTO();
        dto.setStatusCode(entity.getStatusCode());
        dto.setStatusDescription(entity.getStatusDescription());
        return dto;
    }
    
}
