package com.github.lxgang.spring.security.service;

import java.util.List;

import com.github.lxgang.spring.security.beans.AgentResource;


public interface AgentResourceService {
	
	public List<AgentResource> findAll();
	
	public List<AgentResource> findByUsername(String name);
}
