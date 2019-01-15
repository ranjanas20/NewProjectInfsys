package com.bugsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bugsite.entity.BugEntity;

public interface BugRepository extends JpaRepository<BugEntity, Long>  {
	
	@Query(value = "SELECT NEW java.lang.Long ( count(*) ) FROM BugEntity be where be.statusEntity.statusCode not in ('CLS')")
	Long getOpenBugCount();
	
	
	@Query(value = "SELECT NEW java.lang.Long ( count(*) ) FROM BugEntity be where be.statusEntity.statusCode not in ('NEW')")
	Long getNewBugCount();
	
	@Query(value = "SELECT NEW java.lang.Long ( count(*) ) FROM BugEntity be where be.importanceEntity.impCode in ('HGH')")
	Long getHighBugCount();
	
	@Query(value = "SELECT NEW java.lang.Long ( count(*) ) FROM BugEntity be where be.importanceEntity.impCode in ('CRT')")
	Long getCriticalBugCount();
	
}

