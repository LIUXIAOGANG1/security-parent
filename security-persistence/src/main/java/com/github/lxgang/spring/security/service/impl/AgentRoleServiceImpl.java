package com.github.lxgang.spring.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentRole;
import com.github.lxgang.spring.security.repositories.AgentRoleMySQLRepository;
import com.github.lxgang.spring.security.service.AgentRoleService;


@Service
public class AgentRoleServiceImpl implements AgentRoleService {
	
	@Resource
	private AgentRoleMySQLRepository agentRoleMySQLRepository;

	@Override
	public AgentRole findOne(String name) {
		return agentRoleMySQLRepository.findByName(name);
	}

//	@Override
//	public List<AgentRole> findAll() {
//		return agentRoleMySQLRepository.findAll();
//	}

}
