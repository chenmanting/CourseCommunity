<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>ABC网络教室</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<base href=" <%=basePath%>"> 
<LINK href="css/personalstyle.css" type=text/css rel=stylesheet>
<SCRIPT src="js/common.js"></SCRIPT>
<SCRIPT language=JavaScript>
var focusok=false;
if (navigator.appName == "Netscape") {
	focusok=true;
}
vers = navigator.appVersion;
if (navigator.appName == "Microsoft Internet Explorer") {
 pos = vers.lastIndexOf('.'); 
 vers = vers.substring(pos-1,vers.length); 
}
proper_version = parseFloat(vers);

if(proper_version>=5){
	focusok=true;
}

//--展开调用js
var tt='start';
var ii='start';
function turnit(ss,bb) {
  if (ss.style.display=="none") {
    if(tt!='start'){
	 tt.style.display="none";
	 ii.className="Tabon";
	 }
    ss.style.display="";
	bb.className="Taboff";
    tt=ss;
    ii=bb;
  }
  else {
    ss.style.display="none"; 
	bb.className="Tabon";
  }
}

//
// 打开教室
//
function launchchat(name, port, pass,host,course)
{
/*	var name = getCookie("chatname");
	var pass = getCookie("chatpass");*/
	var chat = window.open("RestartRoom.asp?USER="+name+"&PASS="+pass+"&PORT="+port+"&HOST="+host+"&COURSE="+course+"", "chat","top=0,left=0,toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes,Width:790,Height:530");
}

//
// 删除确认
//
function Delete(paramID)
{
	if(confirm('该操作将删除与该课程相关的所有信息,并且不可恢复!是否删除?'))
	{
		window.location.href = "Course/CourseDelete.asp?ID="+paramID;
	}
}

//
// 退出确认
//
function Quit(paramID)
{
	if(confirm('您确认退出该课程吗?'))
	{
		window.location.href = "Course/CourseQuit.asp?ID="+paramID;
	}
}

//
// 成为教师确认
//
function Teacher()
{
	if(confirm('您确认要成为教师吗?'))
	{
		window.location.href = "Teacher/Teacher.asp";
	}
}

function Open(table)
{
	if(document.getElementById(table).style.display == 'none')
	{
		document.getElementById(table).style.display = ''
	}
	else
	{
		document.getElementById(table).style.display = 'none'
	}
}
</SCRIPT>
<META content="MSHTML 6.00.2900.5764" name=GENERATOR></HEAD>
<BODY>
<FORM name=form1 action=Left.asp method=post target=chat align="center">
<TABLE class=case height="100%" cellSpacing=0 cellPadding=0 width=200 
align=center border=0>
  <TBODY>
  <TR>
    <TD vAlign=top align=middle bgColor=#ffffff>
      <TABLE height=27 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD vAlign=center align=middle 
            background=images/per_case_bg.gif><B><IMG height=14 
            src="images/per_ico.gif" width=14 align=absMiddle> 
            我的网络课堂</B></TD></TR></TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 10px; MARGIN-BOTTOM: 15px" height=33 
      cellSpacing=0 cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD class=fff align=middle background=images/per_case2.gif><A 
            href="courses/CourseAdd.jsp" 
            target=Main><IMG height=9 src="images/per_ico4.gif" width=9 
            border=0><B> 开课</B></A> <A 
            href="courses/getAllCourses.action" target=Main><IMG 
            height=9 src="images/per_ico4.gif" width=9 border=0> 
            <B>选课</B></A></TD></TR></TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px" height=33 cellSpacing=0 
      cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/per_case.gif>
            <DIV class=Tabon id=tag1><a href="courses/getMyCourses.action" target="Main" >&nbsp;我的课程</A>
            </DIV></TD></TR></TBODY></TABLE>
      <TABLE id=Content1 style="DISPLAY: none" cellSpacing=6 cellPadding=0 
      border=0>
        <TBODY>
        <TR>
          <TD></TD></TR></TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px" height=33 cellSpacing=0 
      cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/per_case.gif>
            <DIV class=Tabon id=tag2><A 
            href="users/getMyStudents.action" 
            target=Main>&nbsp;课程成员</A></DIV></TD></TR></TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px" height=33 cellSpacing=0 
      cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/per_case.gif>
            <DIV class=Tabon id=tag4 
        onclick=turnit(Content4,tag4) >帐户信息</DIV></TD></TR></TBODY></TABLE>
      <TABLE id=Content4 style="DISPLAY: none" cellSpacing=6 cellPadding=0 
      border=0>
        <TBODY>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="users/UserChangePwd.jsp" 
            target=Main>密码变更</A></TD></TR>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="users/UserEdit.jsp" 
            target=Main>信息修改</A></TD></TR>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="users/UserAvatarChange.jsp" 
            target=Main>更换头像</A></TD></TR>
        </TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px" height=33 cellSpacing=0 
      cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/per_case.gif>
            <DIV class=Tabon id=tag5 
        onclick=turnit(Content5,tag5) >消息中心</DIV></TD></TR></TBODY></TABLE>
      <TABLE id=Content5 style="DISPLAY: none" cellSpacing=6 cellPadding=0 
      border=0>
        <TBODY>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A href="MessageList.htm" target=Main>我的消息</A></TD></TR>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A href="MessageSend.htm" target=Main>发送消息</A></TD></TR></TBODY></TABLE>
      <TABLE style="MARGIN-TOP: 5px; MARGIN-BOTTOM: 5px" height=33 cellSpacing=0 
      cellPadding=0 width=159 border=0>
        <TBODY>
        <TR>
          <TD align=middle background=images/per_case.gif>
            <DIV class=Tabon id=tag6 
        onclick=turnit(Content6,tag6) >课程论坛</DIV></TD></TR></TBODY></TABLE>
      <TABLE id=Content6 style="DISPLAY: none" cellSpacing=6 cellPadding=0 
      border=0>
        <TBODY>
        
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="TopicSearch.htm" 
            target=Main>编程基础</A></TD></TR>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="TopicSearch.htm" 
            target=Main>软件技术</A></TD></TR>
        <TR>
          <TD class=content><IMG src="images/per_ico3.gif" 
            align=absMiddle><A 
            href="TopicSearch.htm" 
            target=Main>课程讨论</A></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></FORM></BODY></HTML>
