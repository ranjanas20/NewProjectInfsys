package com.bugsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bugsite.entity.BugEntity;

public interface BugRepository extends JpaRepository<BugEntity, Long>  {
}

