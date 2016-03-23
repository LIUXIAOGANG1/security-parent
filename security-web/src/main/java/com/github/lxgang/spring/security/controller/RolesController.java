/*package com.github.lxgang.spring.security.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.gmw.skype.beans.agent.core.Roles;
import cn.gmw.skype.persistence.mysql.service.RolesService;

@Controller
@RequestMapping(value = "/background/role")
public class RolesController {
	
	@Resource
	private RolesService rolesService;
	
	
	@RequestMapping(value = "/query.html")
	public String findAll(HttpServletRequest request){
		List<Roles> roles = rolesService.findAll();
		request.setAttribute("roles", roles);
		return "role/list";
	}
	
	@RequestMapping(value = "/addUI.html", method=RequestMethod.GET)
	public String addUI(){
		return "role/add";
	}
	
//	@RequestMapping(value = "/add.html")
//	public String add(Roles role,String rescId){
//		rolesService.saveUserRole(role);
//		return "role/list";
//	}
	

}
*/