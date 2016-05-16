<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Frameset//EN">
<HTML xmlns="http://www.w3.org/1999/xhtml">

<HEAD>
<TITLE>我的网络教室</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 6.00.2900.5764" name=GENERATOR></HEAD>
<FRAMESET border=0 frameSpacing=0 rows=100,*,40 frameBorder=no cols=*>
    <FRAME name=Top marginWidth=0 src="<%=path %>/Top.jsp" noResize scrolling=no>
    <FRAMESET border=0 frameSpacing=0 frameBorder=NO cols=230,*>
        <FRAME name=Left src="<%=path %>/Left.htm" noResize>
        <FRAME name=Main src="<%=path %>/MyCourse.htm">
    </FRAMESET>
    <FRAME name=footFrame src="<%=path %>/foot.htm" noResize scrolling=no>
</FRAMESET>
</HTML>
