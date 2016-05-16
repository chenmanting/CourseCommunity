<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找不到资源</title>
	<style>
		body{
			background-image: url(images/error/404-error.png);
    		width: 100%;
    		-webkit-background-size: cover;
    		-moz-background-size: cover;
    		background-size: cover;
    		-o-background-size: cover;
		}
	</style>

  </head>
  
  <body >
  	<div>
  		
  	</div>
  </body>
</html>
