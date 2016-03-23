package com.github.lxgang.spring.security.tools;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.lxgang.spring.security.beans.AgentRoleResource;
import com.github.lxgang.spring.security.beans.AgentUser;
import com.github.lxgang.spring.security.beans.AgentUserRole;
import com.github.lxgang.spring.security.repositories.AgentRoleResourceMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentUserMySQLRepository;
import com.github.lxgang.spring.security.repositories.AgentUserRoleMySQLRepository;
import com.github.lxgang.spring.security.service.AgentResourceService;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {
	
	@Resource
	private AgentResourceService agentResourceService ;
	
	@Resource
	private AgentUserMySQLRepository agentUserMySQLRepository;
	
	@Resource
    private AgentRoleResourceMySQLRepository agentRoleResourceMySQLRepository;
	
	@Resource
	private AgentUserRoleMySQLRepository agentUserRoleMySQLRepository;
	
	// 登录验证
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//		System.err.println("-----------MyUserDetailServiceImpl loadUserByUsername ----------- ");
		
		//取得用户的权限
		AgentUser users = agentUserMySQLRepository.findByUsername(username);
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(users);
		// 封装成spring security的user
		users.setAuthorities(grantedAuths);
		return users;
	}
	
	

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(AgentUser user) {
		
		//@ TODO 根据用户查询所拥有的资源
//		List<AgentResource> resources = agentResourceService.findAll();
		
		
		List<AgentUserRole> userRole =  agentUserRoleMySQLRepository.findAll(user.getId());
		
		List<AgentRoleResource> roleResources =  agentRoleResourceMySQLRepository.findAll(userRole.get(0).getId().getRoleId());
		
//		agentResourceService.getUserResources(String.valueOf(user.getId()));
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (AgentRoleResource res : roleResources) {
			
			// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			//@ TODO 通过AgentUser读取AgentRoleResource表中的rolkey
			authSet.add(new SimpleGrantedAuthority(res.getRoleKey()));
		}
		return authSet;
	}

}
