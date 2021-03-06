package com.udcode.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.udcode.entity.User;

public class AuthorityPageInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Map session = invocation.getInvocationContext().getSession();
		User user = (User) session.get("user");

		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] cookies = request.getCookies();

		return invocation.invoke();
	}
}
