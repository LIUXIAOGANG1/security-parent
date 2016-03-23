package com.github.lxgang.spring.security.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.lxgang.spring.security.beans.AgentUserRole;
import com.github.lxgang.spring.security.beans.AgentUserRoleId;

public interface AgentUserRoleMySQLRepository extends JpaRepository<AgentUserRole, AgentUserRoleId> {
	@Query("SELECT ur FROM AgentUserRole ur WHERE ur.id.userId = ?1")
	List<AgentUserRole> findAll(Integer userId);
}