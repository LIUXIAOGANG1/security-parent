package com.github.lxgang.spring.security.service;

import java.util.List;

import com.github.lxgang.spring.security.beans.AgentRoleResource;


public interface AgentRoleResourceService {
	
	public List<AgentRoleResource> findOne(int id);
	
	public List<AgentRoleResource> findAll();
}
