package com.github.lxgang.spring.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentUserRoleId;
import com.github.lxgang.spring.security.repositories.AgentUserRoleMySQLRepository;
import com.github.lxgang.spring.security.service.AgentUserRoleService;


@Service
public class AgentUserRoleServiceImpl implements AgentUserRoleService {
	
	@Resource
	private AgentUserRoleMySQLRepository agentUserRoleMySQLRepository;

	@Override
	public AgentUserRoleId findOne(AgentUserRoleId id) {
		return agentUserRoleMySQLRepository.findOne(id).getId();
	}

}
