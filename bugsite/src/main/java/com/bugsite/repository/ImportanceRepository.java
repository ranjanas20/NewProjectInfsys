package com.bugsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugsite.entity.ImportanceEntity;

public interface ImportanceRepository extends JpaRepository<ImportanceEntity, Long>  {

}
