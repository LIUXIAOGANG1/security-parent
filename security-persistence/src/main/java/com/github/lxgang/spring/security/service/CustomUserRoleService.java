package com.github.lxgang.spring.security.service;

import java.util.List;

public interface CustomUserRoleService {
	
	public List<String> findAuthorities(Integer userId);
}
