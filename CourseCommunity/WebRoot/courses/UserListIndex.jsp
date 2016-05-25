<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>我的课程</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/personalstyle.css" rel="stylesheet" type="text/css">
<script src="js/common.js"></script>
</head>

<body>
<table width="98%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="case">
  <tr> 
    <td height="27" background="images/per_case_bg.gif" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="5" cellpadding="0">
        <tr>
          <td><b>现在位置：我的课程</b></td>
        </tr>
      </table></td>
  </tr>
  <tr> 
    <td align="center" valign="top" bgcolor="#FFFFFF">
      <table width="96%" border="0" cellspacing="0" cellpadding="6">
        <tr class="line bold"> 
          <td width="7%" align="center">序号</td>
          <td width="20%" align="center"> 课程名称</td>
          <td width="12%" align="center"> 课程类别</td>
          <td width="16%" align="center"> 开课部门</td>
          <td width="11%" align="center"> 讲课教师</td>
          <td width="14%" align="center"> 创建时间</td>
          <td width="12%" align="center"> 学生人数</td>
          <td width="8%" align="center"> 操作</td>
        </tr>
        <s:iterator value="#session.myTeachCourse" id="c" status="index">
        	<tr align='center'>
            	<td class='line2'><s:property value="#index.index+1"/></td>
            	<td class='line2'><s:property value="#c.title" /></td>
            	<td class='line2'><s:property value="#c.classType" /></td>
            	<td class='line2'><s:property value="#c.college" /></td>
            	<td class='line2'><s:property value="#c.teacher" /></td>
            	<td class='line2'><s:property value="#c.beginTime" /></td>
            	<td class='line2'><s:property value="#c.studentNumber" /></td>
            	<td class='line2'>
            		<button onclick="window.location.href='<%=basePath%>upages/gotoUserList.action?cid=<s:property value="#c.cid" />'">查看成员</button>
            	</td>
        	</tr>
        </s:iterator>
      </table>
	  </td>
  </tr>
</table>
</body>
</html>