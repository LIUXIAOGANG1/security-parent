package com.github.lxgang.spring.security.service;

import com.github.lxgang.spring.security.beans.AgentRole;

public interface AgentRoleService {
	
	public AgentRole findOne(String name);
	
//	public List<AgentRoleResource> findAll();
}
