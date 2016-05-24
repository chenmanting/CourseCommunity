<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>课程搜索</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/personalstyle.css" rel="stylesheet" type="text/css">
<script src="js/common.js"></script>
</head>
<script langauge="javascript">
function goadmin(ss)
{
	var search = ""
	if(document.getElementById("txtSearch").value != "请输入关键字")
	{
		search = document.getElementById("txtSearch").value
	}
	form1.action="CourseSearch.htm";
}
</script>

<body>
<table width="98%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="case">
  <tr> 
    <td height="27" background="images/per_case_bg.gif" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="5" cellpadding="0">
        <tr>
          <td><b>现在位置：课程成员</b></td>
        </tr>
      </table></td>
  </tr>
  <tr> 
    <td align="center" valign="top" bgcolor="#FFFFFF">
      <table width="96%" border="0" cellspacing="0" cellpadding="6">
        <tr class="line bold"> 
          <td width="7%" align="center">序号</td>
          <td width="13%" align="center"> 用户ID</td>
          <td width="10%" align="center"> 姓名</td>
          <td width="13%" align="center"> 学号</td>
          <td width="14%" align="center"> 班级</td>
          <td width="25%" align="center"> Email</td>
          <td width="11%" align="center">手机号码</td>
          <td width="7%" align="center"> 操作</td>
        </tr>
		<tr align='center'>
            <td class='line2'>1</td>
            <td class='line2'><a href="UserInfo.htm">abcdefg</a></td>
            <td class='line2'>张无忌</td>
            <td class='line2'>304050602009</td>
            <td class='line2'>05信计1班</td>
            <td class='line2'>lovenitverymuch@163.com</td>
            <td class='line2'>13905741154</td>
            <td class='line2'><a href="UserList.htm?action=delete&id=abcdef">删除</a></td>
        </tr>
        <tr align='center'>
            <td class='line2'>2</td>
            <td class='line2'><a href="UserInfo.htm">wind123456</a></td>
            <td class='line2'>江上云</td>
            <td class='line2'>304050602009</td>
            <td class='line2'>05信计1班</td>
            <td class='line2'>thisisaemail@163.com</td>
            <td class='line2'>13905742254</td>
            <td class='line2'><a href=UserList.htm?action=delete&id=abcdef>删除</a></td>
        </tr>
        <tr align='center'>
            <td class='line2'>3</td>
            <td class='line2'><a href="UserInfo.htm">fengyuwuzu</a></td>
            <td class='line2'>草上飞</td>
            <td class='line2'>304050602009</td>
            <td class='line2'>05信计2班</td>
            <td class='line2'>javaeeapplication@163.com</td>
            <td class='line2'>13905743354</td>
            <td class='line2'><a href=UserList.htm?action=delete&id=abcdef>删除</a></td>
        </tr>
        <tr align='center'><TD colspan="8">
	        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr class="line bold">
		        <td width="32%" align="left"><input type="submit" value="新增课程成员" onClick=""></td>
		        <td width="68%" align="right" height="26">首页&nbsp;上一页&nbsp;下一页&nbsp;尾页&nbsp;&nbsp;&nbsp;</td>
		    </tr>
		    </table></TD>
        </tr>
      </table>
	  </td>
  </tr>
</table>
</body>
</html>