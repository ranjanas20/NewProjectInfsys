package com.bugsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugsite.entity.StatusEntity;

public interface StatusRepository extends JpaRepository<StatusEntity, Long>  {

}
