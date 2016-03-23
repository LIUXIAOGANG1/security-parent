package com.github.lxgang.spring.security.tools;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.github.lxgang.spring.security.beans.AgentRoleResource;
import com.github.lxgang.spring.security.repositories.AgentRoleResourceMySQLRepository;
import com.github.lxgang.spring.security.service.AgentResourceService;



public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    protected final Log logger = LogFactory.getLog(getClass());

    //从数据库取出权限，url对应的表，拼成requestMap    --》》Map<RequestMatcher, Collection<ConfigAttribute>>
    
    @Resource
    private AgentResourceService resourcesDaoImpl;
    
    @Resource
    private AgentRoleResourceMySQLRepository agentRoleResourceMySQLRepository;
    
    private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

    
    @PostConstruct
    public void init(){
//    	Map<RequestMatcher, Collection<ConfigAttribute>>  requestMap = null;
    	if(requestMap == null){
    		requestMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();
    		List<AgentRoleResource> resources = agentRoleResourceMySQLRepository.findAll();
        	if(resources != null && !resources.isEmpty()){
        		for(AgentRoleResource resource : resources){
//        			Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
    				// TODO:ZZQ 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
//    				configAttributes.add(configAttribute);
    				RequestMatcher matcher = new AntPathRequestMatcher(resource.getResource(),resource.getId().getMethod());
//    				ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + resource.getResKey());
    				Collection<ConfigAttribute> configAttributes = requestMap.get(matcher);
    				if(configAttributes == null || configAttributes.isEmpty()){
    					configAttributes = new ArrayList<ConfigAttribute>();
    					
    				}
    				
    				// @ TODO 原来是Role_  +  resKey;
    				ConfigAttribute configAttribute = new SecurityConfig(resource.getRoleKey());
    				configAttributes.add(configAttribute);
    				
    				requestMap.put(matcher, configAttributes);
    				
        		}
        		
        	}
        	logger.warn(String.valueOf(requestMap));
    	}
    	
    }


    public Collection<ConfigAttribute> getAllConfigAttributes() {
        Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            allAttributes.addAll(entry.getValue());
        }

        return allAttributes;
    }

    public Collection<ConfigAttribute> getAttributes(Object object) {
    	
        final HttpServletRequest request = ((FilterInvocation) object).getRequest();
        for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap.entrySet()) {
            if (entry.getKey().matches(request)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}

