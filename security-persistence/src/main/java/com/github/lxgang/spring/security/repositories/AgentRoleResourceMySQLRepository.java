package com.github.lxgang.spring.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.lxgang.spring.security.beans.AgentRoleResource;
import com.github.lxgang.spring.security.beans.AgentRoleResourceId;

public interface AgentRoleResourceMySQLRepository extends JpaRepository<AgentRoleResource, AgentRoleResourceId> {
	
	public List<AgentRoleResource> findById(int id);
	
	@Query("SELECT ur FROM AgentRoleResource ur WHERE ur.id.roleId = ?1")
	List<AgentRoleResource> findAll(Integer userId);
}