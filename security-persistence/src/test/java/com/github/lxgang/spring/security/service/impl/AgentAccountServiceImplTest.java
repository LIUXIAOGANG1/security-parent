package com.github.lxgang.spring.security.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.lxgang.spring.security.beans.AgentAccount;
import com.github.lxgang.spring.security.service.AgentAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AgentAccountServiceImplTest {
	
	@Resource
	private AgentAccountService agentAccountService;
	
	@Test
	public void findByName(){
		AgentAccount account = agentAccountService.findByName("ROOT");
		System.out.println(account.toString());
	}

}
