package com.bugsite.service;

import static com.bugsite.service.DataConvertUtil.setAuditableNEW;
import static com.bugsite.service.DataConvertUtil.toLocalDateTime;
import static com.bugsite.service.DataConvertUtil.setAuditableMODIFY;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bugsite.dto.BugDTO;
import com.bugsite.dto.BugsCountDTO;
import com.bugsite.dto.BugListResponseDTO;
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
    
    
    public BugDTO getBugById(Long bugId ) {
    	BugEntity entity = bugRepository.getOne(bugId) ;  
        return toBugDTO(entity);
    }
    
    @Transactional
    public BugDTO updateBug(BugDTO dto ) {
    	BugEntity entity = bugRepository.getOne(dto.getBugId()) ;  
    	setDTOToBugEntity(entity,dto);
    	BugEntity savedEntity = bugRepository.save(entity);
        return toBugDTO(savedEntity);
    }

    public BugListResponseDTO<BugDTO> findAllBugsPageWise(Integer pageNo, Integer pageSize,  String sortField, String sortOrder) {
    	Long pageCount= PageHelper.computePages(bugRepository.count(),pageSize);
    	if(pageCount<pageNo) {
    		pageNo=pageCount.intValue();
    	}
    	BugListResponseDTO<BugDTO> dto = new BugListResponseDTO<BugDTO>();
    	Pageable pageable = PageRequest.of(pageNo-1, pageSize, Sort.Direction.fromString(sortOrder), sortField);
        Page<BugEntity> pages= bugRepository.findAll(pageable);
        dto.setTotalPages(pageCount);
        List<BugDTO> list = pages.getContent().stream().map(r-> { return toBugDTO(r);})
                    .collect(Collectors.toList());
        dto.setData(list);
        dto.setPageNumber(pageNo);
        return dto;
    }
    
    public List<BugDTO> findAllBugs() {
    	List<BugEntity> listOfBugs = bugRepository.findAll();
    	return listOfBugs.stream()
    			.map(r -> { return toBugDTO(r);})
    			.collect(Collectors.toList());
    }
    
    public Long getBugsCount() {
    	Long count = bugRepository.count();
    	return count;
    }
    
    public BugsCountDTO getAllBugsCount() {
    	BugsCountDTO dto = new BugsCountDTO();
    	dto.setOpenBugs(bugRepository.getOpenBugCount());
    	dto.setNewBugs(bugRepository.getNewBugCount());
    	dto.setHighBugs(bugRepository.getHighBugCount());
    	dto.setCriticalBugs(bugRepository.getCriticalBugCount());
    	return dto;
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
    
    public void setDTOToBugEntity(BugEntity entity,BugDTO dto){
        entity.setBugId(dto.getBugId());
        entity.setDescription(dto.getDescription());
        entity.setTitle(dto.getTitle());
        entity.setStatusEntity(em.getReference(StatusEntity.class, dto.getStatusCode()));
        entity.setImportanceEntity(em.getReference(ImportanceEntity.class, dto.getImportanceCode()));
        
        setAuditableMODIFY(entity);
    }


	public void deleteById(Long bugId) {
		bugRepository.deleteById(bugId);
	}
    
}
