package com.github.lxgang.spring.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentUser;
import com.github.lxgang.spring.security.repositories.AgentUserMySQLRepository;
import com.github.lxgang.spring.security.service.AgentUserService;


@Service
public class AgentUserServiceImpl implements AgentUserService {

	@Resource
	private AgentUserMySQLRepository agentUserMySQLRepository;
	
	@Override
	public AgentUser findOne(String userName) {
		return agentUserMySQLRepository.findByUsername(userName);
	}

	@Override
	public List<AgentUser> findAll() {
		return agentUserMySQLRepository.findAll();
	}

}
