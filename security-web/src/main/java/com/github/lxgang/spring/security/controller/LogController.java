package com.github.lxgang.spring.security.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.lxgang.spring.security.beans.AgentResource;
import com.github.lxgang.spring.security.beans.AgentUser;
import com.github.lxgang.spring.security.service.AgentResourceService;
import com.github.lxgang.spring.security.service.AgentUserService;



@Controller
public class LogController {
	
	@Resource
	private AgentUserService agentUserService;
	
	@Resource
	private AgentResourceService agentResourceService;
	
	@Resource
	private AuthenticationManager authenticationManager;
	
	@RequestMapping(value="/login.html")
	public String loginUI(AgentUser user){
		return "login";
	}
	
	@RequestMapping(value="/login.html" , method = RequestMethod.POST)
	public String login(Model model,String username,String password,HttpServletRequest request){
		
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			request.setAttribute("error","用户名或密码不能为空！");
			return "/login";
		}
		
		AgentUser users = agentUserService.findOne(username);
		if (users == null || !users.getPassword().equals(password)) {
			request.setAttribute("error", "用户或密码不正确！");
		    return "/login";
		}
		
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		
		HttpSession session = request.getSession(true);  
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
	    // 当验证都通过后，把用户信息放在session里
		request.getSession().setAttribute("userSession", users);
		
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		//String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String username1 = username
//				request.getUserPrincipal().getName();
		List<AgentResource> resources = agentResourceService.findByUsername(username);
		model.addAttribute("resources", resources);
		
		// 记录登录信息
//		UserLoginList userLoginList = new UserLoginList();
//		userLoginList.setUserId(users.getUserId());
//		userLoginList.setLoginIp(Common.toIpAddr(request));
//		userLoginListDao.add(userLoginList);
		return "index";
	}
	
}
