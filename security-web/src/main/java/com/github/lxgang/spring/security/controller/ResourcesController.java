/*package com.github.lxgang.spring.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gmw.skype.beans.agent.core.Resources;
import cn.gmw.skype.persistence.mysql.service.ResourcesService;

@Controller
@RequestMapping(value = "/background/resources")
public class ResourcesController {
	
	@Resource
	private ResourcesService resourcesService;
	
	@RequestMapping(value = "/query.html")
	public String query(Model model,HttpServletRequest request){
		List<Resources> resources = resourcesService.findAll();
		request.setAttribute("resources", resources);
		return "resources/list";
	}
	

	
	@RequestMapping(value = "/addUI.html")
	public String addUI(Model model,HttpServletRequest request){
		return "resources/add";
	}
	
	@RequestMapping(value = "/add.html")
	public String add(Resources resources,HttpServletRequest request){
		resourcesService.add(resources);
		return "resources/list";
	}
	
	*//**
	 * 某个角色拥有的权限
	 * @return
	 *//*
	@RequestMapping(value="permissioRole")
	public String permissioRole(Model model,String roleId,HttpServletRequest request){
		List<Resources> resources = resourcesService.getRoleResources(roleId);
		List<Resources> allRes = resourcesService.findAll();
		StringBuffer sb = new StringBuffer();
		sb.append("var data = [];");
		for (Resources r : allRes) {
			boolean flag = false;
			for (Resources ur : resources) {//用户拥有的权限
				if (ur.getId().equals(r.getId())) {
					sb.append("data.push({ fid: '"
							+ r.getId() + "', pfid: '"
							+ r.getParentId()
							+ "', fname: '" + r.getName()
							+ "',ischecked: true});");
					flag = true;
				}
			}
			if (!flag) {
				sb.append("data.push({ fid: '"
						+ r.getId() + "', pfid: '"
						+ r.getParentId()
						+ "', fname: '" + r.getName()
						+ "'});");

			}
		}
		request.setAttribute("roleId", roleId);
		request.setAttribute("resources", sb);
		return "resources/permissioUser";
	}
	
	@ResponseBody
	@RequestMapping(value="saveRoleRescours")
	public String saveRoleRescours(String roleId,String rescId){
		String errorCode = "1000";
		List<String> list = removeSameItem(Arrays.asList(rescId.split(",")));
		try {
			resourcesService.saveRoleRescours(roleId, list);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
	
	
	*//**
	 * 用来去掉List中空值和相同项的。
	 * 
	 * @param list
	 * @return
	 *//*
	public static List<String> removeSameItem(List<String> list) {
		List<String> difList = new ArrayList<String>();
		for (String t : list) {
			if (t != null && !difList.contains(t)) {
				difList.add(t);
			}
		}
		return difList;
	}
	
	
}
*/