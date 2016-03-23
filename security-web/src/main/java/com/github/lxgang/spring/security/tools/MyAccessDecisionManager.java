package com.github.lxgang.spring.security.tools;
import java.util.Collection;

import java.util.Iterator;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
/**
 * 自己实现的过滤用户请求类，也可以直接使用 FilterSecurityInterceptor
 * 
 * AbstractSecurityInterceptor有三个派生类：
 * FilterSecurityInterceptor，负责处理FilterInvocation，实现对URL资源的拦截。
 * MethodSecurityInterceptor，负责处理MethodInvocation，实现对方法调用的拦截。
 * AspectJSecurityInterceptor，负责处理JoinPoint，主要是用于对切面方法(AOP)调用的拦截。
 * 
 * 还可以直接使用注解对Action方法进行拦截，例如在方法上加：
 * @PreAuthorize("hasRole('ROLE_SUPER')")
 * <!-- 用户是否拥有所请求资源的权限 -->
 * 
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {
	
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//		System.err.println(" ---------------  MyAccessDecisionManager --------------- ");
		if(configAttributes == null) {
			return;
		}
		//所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		
		
//		context.setVariable("authority", "addUser");  				//求值：通过Expression接口的getValue方法根据上下文获得表达式值。  
		
		while(iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			//访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			
			//System.out.println("needPermission is " + needPermission);
			//用户所拥有的权限authentication
			for(GrantedAuthority ga : authentication.getAuthorities()) {
				ExpressionParser parser = new SpelExpressionParser();  		//解析表达式：使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象。
				String ga1 = "#authority matches '^"+ ga.getAuthority() +".*$'";
				Expression expression = parser.parseExpression(ga1);  		//构造上下文：准备比如变量定义等等表达式需要的上下文数据。  
				EvaluationContext context = new StandardEvaluationContext();  
				context.setVariable("authority", needPermission);  				//求值：通过Expression接口的getValue方法根据上下文获得表达式值。  
				ga.getAuthority();
//				if(needPermission.equals(ga.getAuthority())) {
				if((boolean) expression.getValue(context)) {
					
					//TODO 增加通配符测试  SpelExpression
//					ExpressionParser parser = new SpelExpressionParser(); 
					return;
				}
			}
		}
		//没有权限
		throw new AccessDeniedException(" 没有权限访问！ ");
	}

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
//	public static void main(String[] args) {
//		ExpressionParser parser = new SpelExpressionParser(); 
//		String expression1 = "2>1 and (!true or !false)";  
//		boolean result1 = parser.parseExpression(expression1).getValue(boolean.class);  
//		System.out.println(result1);
//
//		String a = "admin_add_user";
//		String b = "admin_add_";
//		System.out.println(b.indexOf(a));
//	
//	}
	
//	public static void main(String[] args) {
//		Pattern p = Pattern.compile("add.*"); 
//		Matcher m = p.matcher("ad1dUser");
//		System.out.println(m.matches()); 
//	}
	
//	public static void main(String[] args) {
//		SpelExpression
//		ExpressionParser parser = new SpelExpressionParser();  
//		//解析表达式：使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象。  
//		Expression expression = parser.parseExpression("#authority matches '^add.*$'");  
//		System.out.println(expression.getExpressionString());  
//		//构造上下文：准备比如变量定义等等表达式需要的上下文数据。  
//		EvaluationContext context = new StandardEvaluationContext();  
//		context.setVariable("authority", "addAdmin.html");  
//		//求值：通过Expression接口的getValue方法根据上下文获得表达式值。  
//		System.out.println(expression.getValue(context));  
//	}
	
}