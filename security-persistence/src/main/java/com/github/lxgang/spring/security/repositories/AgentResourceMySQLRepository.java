package com.github.lxgang.spring.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.lxgang.spring.security.beans.AgentResource;

public interface AgentResourceMySQLRepository extends JpaRepository<AgentResource, Integer> {
	@Query("SELECT ur FROM AgentResource ur WHERE ur.id = ?1")
	List<AgentResource> findAll(Integer userId);
}