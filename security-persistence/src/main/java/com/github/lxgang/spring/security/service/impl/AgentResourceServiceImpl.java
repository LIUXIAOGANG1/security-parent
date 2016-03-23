package com.github.lxgang.spring.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentResource;
import com.github.lxgang.spring.security.beans.AgentRoleResource;
import com.github.lxgang.spring.security.beans.AgentUser;
import com.github.lxgang.spring.security.beans.AgentUserRole;
import com.github.lxgang.spring.security.repositories.AgentResourceMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentRoleMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentRoleResourceMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentUserMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentUserRoleMySQLRepository;
import com.github.lxgang.spring.security.service.AgentResourceService;


@Service
public class AgentResourceServiceImpl implements AgentResourceService {
	
	@Resource
	private AgentResourceMySQLRepository agentResourceMySQLRepository;
	
	@Resource
	private AgentRoleResourceMySQLRepository agentRoleResourceMySQLRepository;
	
	@Resource
	private AgentUserMySQLRepository agentUserMySQLRepository;
	
	
	@Resource
	private AgentUserRoleMySQLRepository agentUserRoleMySQLRepository;
	
	@Resource
	private AgentRoleMySQLRepository agentRoleMySQLRepository;

	@Override
	public List<AgentResource> findAll() {
		return agentResourceMySQLRepository.findAll();
	}

	@Override
	public List<AgentResource> findByUsername(String name) {
		AgentUser user = agentUserMySQLRepository.findByUsername(name);
		AgentUserRole agentUserRole = agentUserRoleMySQLRepository.findAll(user.getId()).get(0);
		
		
		List<AgentRoleResource> roleResources = agentRoleResourceMySQLRepository.findAll(agentUserRole.getId().getRoleId());
		
		List<AgentResource> resources = new ArrayList<AgentResource>();
		for(AgentRoleResource agentRoleResource : roleResources){
			AgentResource resource = agentResourceMySQLRepository.findOne(agentRoleResource.getId().getResourceId());
			resources.add(resource);
		}
		return resources;
	}

}
