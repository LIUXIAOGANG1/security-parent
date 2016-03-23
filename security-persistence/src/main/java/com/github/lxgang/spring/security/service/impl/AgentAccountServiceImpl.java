package com.github.lxgang.spring.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentAccount;
import com.github.lxgang.spring.security.repositories.AgentAccountMySQLRepository;
import com.github.lxgang.spring.security.service.AgentAccountService;

@Service
public class AgentAccountServiceImpl implements AgentAccountService {
	
	@Resource
	private AgentAccountMySQLRepository agentAccountMySQLRepository;

	@Override
	public AgentAccount findByName(String name) {

		return agentAccountMySQLRepository.findByName(name);
	}

}
