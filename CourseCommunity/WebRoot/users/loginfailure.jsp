<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logout.jsp' starting page</title>
    <script language="javascript">
    	var url ="users/login.jsp"  
		function reloadurl(){ window.location.href=url; }  
		window.setTimeout("reloadurl();",2000)  
	</script>

  </head>
  
  <body>
    	<h2>登录失败！</h2><br>
    	<h2>你可能用户名写错了...</h2>
    	<h2>你可能密码写错了...</h2>
    	<h2>你可能验证码也写错了...</h2>
    	<h2>呆会就返回登录页面...</h2>
  </body>
  
</html>
