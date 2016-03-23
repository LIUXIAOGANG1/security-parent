package com.github.lxgang.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lxgang.spring.security.beans.AgentAccount;

public interface AgentAccountMySQLRepository extends JpaRepository<AgentAccount, Integer> {
	
	public AgentAccount findByName(String name);
}