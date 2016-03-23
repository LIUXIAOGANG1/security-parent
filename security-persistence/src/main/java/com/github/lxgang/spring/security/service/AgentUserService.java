package com.github.lxgang.spring.security.service;

import java.util.List;

import com.github.lxgang.spring.security.beans.AgentUser;

public interface AgentUserService {
	public AgentUser findOne(String userName);
	
	public List<AgentUser> findAll();
}
