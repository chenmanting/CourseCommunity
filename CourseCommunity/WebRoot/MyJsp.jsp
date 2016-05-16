<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<form id="mform">
	
		<button type="submit" > submit</button>
	</form>
  </body>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript">
  		//表单检验
		function submitCheck(){
			var username = $("#username").val();
			var password = $("#password").val();
			var password1 = $("#password1").val();
			//一些判断是否为空。密码是否一致....
			var url = "<%=basePath%>users/User_checkUsername.action";
			$.ajax({
				type:'POST',
				url: url,
				data: {'username':username},
				success:function(result){
    				if("false" == result){
    					$("#usernameStatus").text("该账户可以使用");
						$("#usernameStatus").css("color","green");
						return true;
					}else{
						$("#usernameStatus").text("该账户已被使用");
						$("#usernameStatus").css("color","red");
						return false;
					}
    			},
				error: function(){
					alert("error");
				}
			});
			return false;
		}
  </script>
</html>
