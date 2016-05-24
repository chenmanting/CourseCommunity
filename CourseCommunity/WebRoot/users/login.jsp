<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
<HEAD><TITLE>登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<base href=" <%=basePath%>"> 
<LINK href="css/frontstyle.css" type=text/css rel=stylesheet>
<SCRIPT language=javascript type=text/javascript>
	//选择显示
	function Change()
	{
		form1.images.src="check/checkcode.asp";
	}
	
	function CheckInput()
	{
		if(document.all["username"].value.length == 0)
		{
			alert("请输入用户名.")
			document.all["username"].focus();
			return false;
		}
		if(document.all["password"].value.length == 0)
		{
			alert("请输入密码.")
			document.all["password"].focus();
			return false;
		}
		/*
		if(document.all["verify"].value.length == 0)
		{
			alert("请输入验证码.")
			document.all["verify"].focus();
			return false;
		}*/
		//form1.action = "main.htm?Action=Login&rurl="+url;
		return true;
	}
    </SCRIPT>
</HEAD>
<BODY>
<FORM name=form1 action="<%=path%>/users/login.action" method=post>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
  <TBODY>
  <TR>
    <TD align=middle>
      <TABLE height=52 cellSpacing=0 cellPadding=0 width=488 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/login-bg.gif>
            <TABLE cellSpacing=0 cellPadding=0 width=457 border=0>
              <TBODY>
              <TR>
                <TD class="casety bold">信计系课程社区 / 轻松开始学习!</TD>
                <TD class="casety bold" align=right><FONT 
                  color=#ffff00>用户登录</FONT><SPAN class=enfont>/ 
                UserLogin</SPAN></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=492 align=center border=0>
        <TBODY>
        <TR>
          <TD class=default1>
            <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
              <TBODY>
              <TR>
                <TD class=default2 align=middle>
                  <TABLE style="MARGIN-TOP: 20px; MARGIN-BOTTOM: 15px" 
                  cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD style="BORDER-RIGHT: #fe5200 1px dotted" 
                        width=180><A href="index.htm"><IMG 
                        height=48 src="images/logo.gif" width=159 
                        border=0></A></TD>
                      <TD width=240>
                        <TABLE style="MARGIN-LEFT: 15px" cellSpacing=0 
                        cellPadding=2 border=0>
                          <TBODY>
                          <TR>
                            <TD class=bold align=right width=55>用户名：</TD>
                            <TD colSpan=2><INPUT class=input name=username 
                              width="100%"></TD></TR>
                          <TR>
                            <TD class=bold align=right>密　码：</TD>
                            <TD colSpan=2><INPUT class=input type=password 
                              maxLength=12 name=password width="100%"></TD></TR> 
                          <TR>
                            <TD class=bold align=right>验证码：</TD>
                            <TD width=60><INPUT class=input maxLength=4 
                              name=verify width="100%" value="8khh" id=verify></TD>
                            <TD><IMG onClick="Change();" 
                              src="users/getCheckCode.action?rand=+Math.random();" align=absMiddle 
                              border=0 name=images id=checkCode></TD></TR>
                          <TR>
                            <TD>&nbsp; </TD>
                            <TD colSpan=2><A 
                              href="users/register.jsp"><B><FONT 
                              color=#ff3300>注册帐号</FONT></B></A> <A 
                              href="javascript:void(0);" onclick="forgetPwd()">忘密？</A></TD></TR>
                          <TR>
                            <TD>&nbsp; </TD>
                            <TD colSpan=2>
                            <INPUT type=image height=28 width=83 
                              src="images/btn-login_.gif" border=0 onclick="return CheckInput()"
                              ></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
      <TABLE height=30 cellSpacing=0 cellPadding=0 width=492 align=center 
      border=0>
        <TBODY>
        <TR>
          <TD style="BACKGROUND-POSITION: 50% top; BACKGROUND-REPEAT: no-repeat" 
          width=25 background=images/sidebl2.gif>&nbsp; </TD>
          <TD vAlign=top background=images/sidebb2.gif><IMG height=16 
            src="images/ico12.gif" width=16 align=absMiddle> <A 
            href=""><U>隐私申明</U></A> 
          </TD>
          <TD style="BACKGROUND-POSITION: 50% top; BACKGROUND-REPEAT: no-repeat" 
          width=25 background=images/sidebr2.gif>&nbsp; 
      </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM></BODY>
      
		<script type="text/javascript">
			
			function Change(){
				var s ="users/getCheckCode.action";
				document.getElementById("checkCode").src=s+"?rand="+Math.random();
			}
			function forgetPwd(){
				alert("暂未实现");
			}
		</script>   
      
</HTML>
