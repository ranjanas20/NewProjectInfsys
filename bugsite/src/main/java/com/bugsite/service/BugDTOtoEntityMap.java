package com.bugsite.service;

import com.bugsite.dto.BugDTO;
import com.bugsite.dto.StatusDTO;
import com.bugsite.entity.BugEntity;
import com.bugsite.entity.ImportanceEntity;
import com.bugsite.entity.StatusEntity;

import static com.bugsite.service.DataConvertUtil.*;

public class BugDTOtoEntityMap {
	
    public static BugEntity toBugEntity(BugDTO dto){
        BugEntity entity = new BugEntity();
        entity.setBugId(dto.getBugId());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatusEntity(new StatusEntity(dto.getStatusCode()));
        entity.setImportanceEntity(new ImportanceEntity(dto.getImportanceCode()));
        setAuditableNEW(entity);
        return entity;        
    }
    
    public static BugDTO toBugDTO(BugEntity entity){
    	BugDTO dto = new BugDTO();
        dto.setBugId(entity.getBugId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setImportanceCode(entity.getImportanceEntity().getImpCode());
        dto.setStatusCode(entity.getStatusEntity().getStatusCode());
        dto.setUpdatedOn(toLocalDateTime(entity.getUpdatedOn()));
        dto.setCreatedOn(toLocalDateTime(entity.getCreatedOn()));
        dto.setUpdatedBy("admin");
        dto.setCreatedBy("admin");
        return dto;
    }
    
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
