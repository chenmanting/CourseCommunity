package com.cmt.intercepter;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invoker) throws Exception {

		Object loginUser = ActionContext.getContext().getSession()
				.get("user");
		if (null == loginUser){
			System.out.println("拦截未登录");
			return "login";
		}
		return invoker.invoke();
	}
}
