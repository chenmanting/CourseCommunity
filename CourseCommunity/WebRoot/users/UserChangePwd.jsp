<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<html>
<head>
<title>密码修改</title>
<base target="_self" />
<link rel="stylesheet" type="text/css" href="css/PersonalStyle.css">
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
<form name="form1" method="post" action="<%=path%>/users/User_updatePassword.action" id="form1">
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
                        <input type="submit" name="btnConfirm" value="确定(C)" onclick="return CheckInput(true);" id="btnConfirm" accesskey="C" tabindex="4" class="bt" />
                    </td>
                </tr>
            </table>
        </td>
    </tr>
        </table>
</form>
</body>
<script language="javascript">
	document.all["txtOldPassword"].focus();
	
</script>
</html>
