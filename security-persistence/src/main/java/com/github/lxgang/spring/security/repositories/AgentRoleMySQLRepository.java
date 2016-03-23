package com.github.lxgang.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lxgang.spring.security.beans.AgentRole;


public interface AgentRoleMySQLRepository extends JpaRepository<AgentRole, Integer> {
	
	public AgentRole findByName(String name);
	
}