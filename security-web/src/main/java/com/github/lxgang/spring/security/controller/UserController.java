package com.github.lxgang.spring.security.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.lxgang.spring.security.beans.AgentUser;
import com.github.lxgang.spring.security.beans.AgentUserRole;
import com.github.lxgang.spring.security.service.AgentRoleService;
import com.github.lxgang.spring.security.service.AgentUserService;


@Controller
public class UserController {
	
	@Resource
	private AgentUserService userService;
	
	@Resource
	private AgentRoleService rolesService;
	
//	@Resource
//	private UserService userService;
	
	@RequestMapping(value = "/userAdd.html" , method=RequestMethod.GET)
	public String addUI(HttpServletRequest request){
		return "user/add";
	}
	
	
	@RequestMapping(value = "/addUser.html" , method=RequestMethod.POST)
	public String addUser(AgentUser user,HttpServletRequest request){
//		userService.save(user);
		AgentUser u = new AgentUser();
//		List<AgentUser> users = userService.queryAll(u);
//		request.setAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping(value = "/query.html" )
	public String query(HttpServletRequest request){
//		userService.save(user);
		AgentUser u = new AgentUser();
		List<AgentUser> users = userService.findAll();
//		List<>
		request.setAttribute("users", users);
		AgentUser user = (AgentUser)request.getSession().getAttribute("userSession");
//		List<AgentResource> resources = rolesService.findRes(String.valueOf(user.getUserId()));
//		request.setAttribute("resources", resources);
		return "user/list";
	}
	
	@RequestMapping(value = "/userRole.html")
	public String userRole(HttpServletRequest request, String userId){
		AgentUser user = userService.findOne(userId);
		request.setAttribute("user", user);
//		List<AgentRole> roles = rolesService.findAll();
//		request.setAttribute("roles", roles);
		return "user/userRole";
	}
	
	/**
	 * 保存用户分配角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("allocation")
	public String allocation(Model model, AgentUserRole userRoles){
		String errorCode = "1000";
		try {
//			rolesService.saveUserRole(userRoles);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
	
	
}
