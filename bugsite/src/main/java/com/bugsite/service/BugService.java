package com.bugsite.service;

import static com.bugsite.service.DataConvertUtil.setAuditableNEW;
import static com.bugsite.service.DataConvertUtil.toLocalDateTime;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsite.dto.BugDTO;
import com.bugsite.entity.BugEntity;
import com.bugsite.entity.ImportanceEntity;
import com.bugsite.entity.StatusEntity;
import com.bugsite.repository.BugRepository;

@Service
public class BugService {
    
    @Autowired
    private BugRepository bugRepository;
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public BugDTO addBug(BugDTO dto ) {
        BugEntity savedEntity = bugRepository.save(toBugEntity(dto));
        return toBugDTO(savedEntity);
    }

    public List<BugDTO> findAllBugs() {
    	/*Integer pageNo, Integer pageSize*/
        /*Pageable page = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, "bugId");
        Page<BugEntity> pages= bugRepository.findAll(page);
        
        return pages.getContent()
        			.stream()
        			.map(r-> { return toBugDTO(r);})
        			.collect(Collectors.toList()); */
    	List<BugEntity> listOfBugs = bugRepository.findAll();
    	return listOfBugs.stream()
    			.map(r -> { return toBugDTO(r);})
    			.collect(Collectors.toList());
    }
    
    public BugEntity toBugEntity(BugDTO dto){
        BugEntity entity = new BugEntity();
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatusEntity(em.getReference(StatusEntity.class, dto.getStatusCode()));
        entity.setImportanceEntity(em.getReference(ImportanceEntity.class, dto.getImportanceCode()));
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
        dto.setStatusDescription(entity.getStatusEntity().getStatusDescription());
        dto.setImportanceDescription(entity.getImportanceEntity().getImpDescription());
        dto.setUpdatedOn(toLocalDateTime(entity.getUpdatedOn()));
        dto.setCreatedOn(toLocalDateTime(entity.getCreatedOn()));
        dto.setUpdatedBy("admin");
        dto.setCreatedBy("admin");
        return dto;
    }
    
}
