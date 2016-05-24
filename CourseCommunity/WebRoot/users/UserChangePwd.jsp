<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
<title>密码修改</title>
<base target="_self" />
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/personalstyle.css">
<script language="javascript" src="js/Default.js"></script>
<script language="javascript">
document.onkeydown = function EnterToTab() {
    if (event.keyCode == 13 && event.srcElement.type!='button' && event.srcElement.type!='submit' && event.srcElement.type!='file' && event.srcElement.type!='reset' && event.srcElement.type!='textarea' && event.srcElement.type!='') {
        event.keyCode = 9
    }
}
</script>
</head>
<body>
<form name="form1" method="post"  id="form1">
<table width="98%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0"
    class="case">
    <tr>
        <td height="27" background="images/per_case_bg.gif"
            bgcolor="#FFFFFF">
            <table width="100%" border="0" cellspacing="5" cellpadding="0">
                <tr>
                    <td>
                        <b>现在位置：个人信息 &gt; 密码修改</b></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
        <td valign="top" bgcolor="#FFFFFF">
            <table border="0" width="100%" cellspacing="5" cellpadding="0">
                
                <tr height="25">
                    <td width="100">
                        原始密码：<font color="red">*</font>
                    </td>
                    <td>
                        <input name="txtOldPassword" type="password" maxlength="12" id="txtOldPassword" tabindex="1" class="input" /></td>
                    <td width="200">
                    </td>
                </tr>
                <tr height="25">
                    <td>
                        新密码：<font color="red">*</font>
                    </td>
                    <td>
                        <input name="txtNewPassword" type="password" maxlength="12" id="txtNewPassword" tabindex="2" class="input" />
                    </td>
                    <td width="200">
                    </td>
                </tr>
                <tr height="25">
                    <td>
                        确认密码：<font color="red">*</font>
                    </td>
                    <td>
                        <input name="txtConfirmPassword" type="password" maxlength="12" id="txtConfirmPassword" tabindex="3" class="input" />
                    </td>
                    <td width="200">
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        </td>
                    <td colspan="2">
                        <input type="submit" name="btnConfirm" value="确定(C)" onclick="return submitForm();" id="btnConfirm" accesskey="C" tabindex="4" class="bt" />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
        </table>
</form>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
	document.all["txtOldPassword"].focus();
	function submitForm(){
		var oldP = $("#txtOldPassword").val();
		
		if(oldP == undefined || oldP == "" || oldP == null){
			alert("请输入原始密码！");
			return false;
		}
		
		var newP = $("#txtNewPassword").val();
		var comfirmP = $("#txtConfirmPassword").val();
		if(newP != comfirmP){
			alert("俩次密码输入不一致");
			return false;
		}
		var url = "<%=path%>/users/updatePassword.action";
		$.ajax({
			url: url,
			data:{
				'txtOldPassword':$("#txtOldPassword").val(),
				'txtNewPassword':$("#txtNewPassword").val()
				},
			cache:false,
			success:function(result){
				//alert(result);
   				if("oldPwdError" == result){
   					alert("原始密码输入错误！");
				}else if("updatePwdSuccess" == result){
					alert("密码修改成功！");
				}else if("updatePwdFailure" ==  result){
					alert("密码修改失败！");
				}else{
					alert("其它原因导致密码修改失败~");
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
