package com.github.lxgang.spring.security.repositories;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserRoleMySQLRepository {
	
	@Resource
	private DataSource dataSource;
	
	public List<String> findAuthorities(Integer userId) {
		String sql = "SELECT agent_role.`key` FROM agent_role, agent_user_role WHERE agent_user_role.userId = ?";
		List<String> authorities = new JdbcTemplate(dataSource).queryForList(sql, new Object[]{userId}, String.class);
		return authorities;
	}
}