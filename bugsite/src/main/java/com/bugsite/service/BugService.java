package com.bugsite.service;

import static com.bugsite.service.BugDTOtoEntityMap.toBugDTO;
import static com.bugsite.service.BugDTOtoEntityMap.toBugEntity;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugsite.dto.BugDTO;
import com.bugsite.entity.BugEntity;
import com.bugsite.repository.BugRepository;

@Service
public class BugService {
    
    @Autowired
    private BugRepository bugRepository;
    
   
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
    
}
