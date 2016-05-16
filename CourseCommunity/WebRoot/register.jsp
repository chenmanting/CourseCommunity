<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ע��ҳ��</title>
    
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
  </head>
  
  <body>
  	
  	<div class="container">
  	<h2 class="text-center">ע��ҳ��</h2>
  	<hr>
  	
  	<div class="row">
  	<div class="col-xs-6 col-md-offset-3">
	<form class="form-horizontal" role="form" id="myForm"  action="<%=basePath%>users/User_registe.action" method=post>
   		
   		<div class="form-group" >
      		<label for="username" class="col-sm-2 control-label">�û���</label>
	      	<div class="col-sm-10">
	        <input type="text" name="username" class="form-control" id="username" 
            	placeholder="�������û���" >
            	<span id="usernameStatus">
      		</div>
   		</div>
   		<div class="form-group">
      		<label for="password"  class="col-sm-2 control-label">����</label>
      		<div class="col-sm-10">
         	<input type="password" name="password" class="form-control" id="password" 
            	placeholder="����������">
            <span id="pwdStatus">
      		</div>
   		</div>
   		<div class="form-group">
      		<label for="password1" class="col-sm-2 control-label">����</label>
      		<div class="col-sm-10">
         	<input type="password" class="form-control" id="password1" 
            	placeholder="���ٴ���������" >
            <span id="pwd1Status">
      		</div>
   		</div>
   		
   		<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
         		<button type="submit"  onclick="return clickSubmitBtn()" class="btn btn-default">ע��</button>
      		</div>
   		</div>
	</form>
	</div>
	</div>
	</div>
  </body>
  
  	<script type="text/javascript" src="js/jquery.js"></script>
  	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	
	<script type="text/javascript">
	
		$("#username").focus(function(){
			 $("#usernameStatus").text("");
		});
		
		$("#username").blur(function(){
			if(username.value == undefined || username.value  == "" || username.value  == null){
				$("#usernameStatus").text("�������û���");
				$("#usernameStatus").css("color","red");
				return false;
			}
			var url = "<%=basePath%>users/User_checkUsername.action";

			$.ajax({
				type:'POST',
				url: url,
				data:{ username :username.value},
				success:function(result){
    				if("false" == result){
						$("#usernameStatus").text("���˻�����ʹ��");
						$("#usernameStatus").css("color","green");
					}else{
						$("#usernameStatus").text("���˻��ѱ�ʹ��");
						$("#usernameStatus").css("color","red");
					}
    			},
				error: function(){
					alert("error");
				}
			});
		});
	
		$("#password").focus(function(){
			 $("#pwdStatus").text("");
		});
		
		$("#password").blur(function(){
			var password = $("#password").val();
			if(password == undefined || password == "" || password == null){
				$("#pwdStatus").text("����������");
				$("#pwdStatus").css("color","red");
			}
		});
		
		$("#password1").focus(function(){
			 $("#pwd1Status").text("");
		});
		
		$("#password1").blur(function(){
			var password = $("#password1").val();
			if(password == undefined || password == "" || password == null){
				$("#pwd1Status").text("����������");
				$("#pwd1Status").css("color","red");
			}
			if($("#password").val() != $("#password1").val()){
				$("#pwd1Status").text("�����������벻һ��");
				$("#pwd1Status").css("color","red");
			}
		});
		
		function clickSubmitBtn() {
			var username = $("#username").val();
			var password = $("#password").val();
			var password1 = $("#password1").val();
			var $form = $("#myForm");
   			var url = "<%=basePath%>users/User_checkUsername.action";
   			
			if(username == undefined || username == "" || username == null){
				$("#usernameStatus").text("�������û���");
				$("#usernameStatus").css("color","red");
				return false;
			}

			if(password == undefined || password == "" || password == null){
				$("#pwdStatus").text("����������");
				$("#pwdStatus").css("color","red");
				return false;
			}
			
			if(password1 == undefined || password1 == "" || password1 == null){
				$("#pwd1Status").text("����������");
				$("#pwd1Status").css("color","red");
				return false;
			}
			
			if(password!= password1){
				$("#pwd1Status").text("�����������벻һ��");
				$("#pwd1Status").css("color","red");
				return false;
			}
			
			var user = {
				username:username,
				password:password
			};

       		$.ajax({
				type:'POST',
				url: url,
				data: user,
				cache:false,
				success:function(result){
   					if("false" == result){
   						$("#usernameStatus").text("���˻�����ʹ��");
						$("#usernameStatus").css("color","green");
						//alert(password);
						$form.submit();
					}else{
						$("#usernameStatus").text("���˻��ѱ�ʹ��");
						$("#usernameStatus").css("color","red");
					}
   				},
				error: function(){
					alert("error");
				}
			});
        	return false;
		};
		/*
		//������2
		function submitCheck(){

			var username = $("#username").val();
			var password = $("#password").val();
			var password1 = $("#password1").val();
			
			if(username == undefined || username == "" || username == null){
				$("#usernameStatus").text("�������û���");
				$("#usernameStatus").css("color","red");
				return false;
			}

			if(password == undefined || password == "" || password == null){
				$("#pwdStatus").text("����������");
				$("#pwdStatus").css("color","red");
				return false;
			}
			
			if(password1 == undefined || password1 == "" || password1 == null){
				$("#pwd1Status").text("����������");
				$("#pwd1Status").css("color","red");
				return false;
			}
			
			if(password != password1){
				$("#pwd1Status").text("�����������벻һ��");
				$("#pwd1Status").css("color","red");
				return false;
			}
	
			var url = "<%=basePath%>users/User_checkUsername.action";
			//alert($("#username").val());
			var ajaxFlag = false;
			$.ajax({
				type:'POST',
				url: url,
				data: {'username':username},
				async:false,
				cache:false,
				success:function(result){
    				if("false" == result){
    					$("#usernameStatus").text("���˻�����ʹ��");
						$("#usernameStatus").css("color","green");
						ajaxFlag = true;
					}else{
						$("#usernameStatus").text("���˻��ѱ�ʹ��");
						$("#usernameStatus").css("color","red");
						
					}
    			},
				error: function(){
					alert("error");
					
				}
			});
			return ajaxFlag;
		}
		*/
	</script>
  
</html>
