package com.github.lxgang.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lxgang.spring.security.beans.AgentUser;


public interface AgentUserMySQLRepository extends JpaRepository<AgentUser, Integer> {
	AgentUser findByUsername(String username);
}