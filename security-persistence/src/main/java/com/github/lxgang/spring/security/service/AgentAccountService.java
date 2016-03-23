package com.github.lxgang.spring.security.service;

import com.github.lxgang.spring.security.beans.AgentAccount;

public interface AgentAccountService {
	public AgentAccount findByName(String name);
}
