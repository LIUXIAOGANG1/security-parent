package com.github.lxgang.spring.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentRoleResource;
import com.github.lxgang.spring.security.repositories.AgentRoleResourceMySQLRepository;
import com.github.lxgang.spring.security.service.AgentRoleResourceService;


@Service
public class AgentRoleResourceServiceImpl implements AgentRoleResourceService {
	
	@Resource
	private AgentRoleResourceMySQLRepository agentRoleResourceMySQLRepository;

	@Override
	public List<AgentRoleResource> findOne(int id) {
		return agentRoleResourceMySQLRepository.findById(id);
	}

	@Override
	public List<AgentRoleResource> findAll() {
		return agentRoleResourceMySQLRepository.findAll();
	}

}
