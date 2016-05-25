<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<html>
<head>
<title>课程搜索</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">   
<link href="css/personalstyle.css" rel="stylesheet" type="text/css">
<script src="js/common.js"></script>
</head>

<body>
<table width="98%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="case">
  <tr> 
    <td height="27" background="images/per_case_bg.gif" bgcolor="#FFFFFF"><table width="100%" border="0" cellspacing="5" cellpadding="0">
        <tr>
          <td><b>现在位置：课程查询</b></td>
        </tr>
      </table></td>
  </tr>
  <tr> 
    <td align="center" valign="top" bgcolor="#FFFFFF">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<input type=hidden name='ss' value=''>
	<tr>
    	<td height="40" align="center" class="font4">
			 	课程名称：<input type="text" name="txtCourseName" id="txtCourseName" style="width: 100px" /> &nbsp;
             	讲课教师：<input type="text" name="txtCourseTeacher" id="txtCourseTeacher" style="width: 100px" /> &nbsp;
             	开课部门:
                <select name="college" type="text" maxlength="30" id="txtCourseCollege" tabindex="3" class="input" onFocus="" style="width:200px;" >
                    <OPTION value="" selected>请选择</OPTION> <OPTION value="信息分院">信息分院</OPTION> 
                    <OPTION value="机电分院">机电分院</OPTION> <OPTION value="外语分院">外语分院</OPTION> 
                    <OPTION value="法传分院">法传分院</OPTION> <OPTION value="经济分院">经济分院</OPTION> 
              		<OPTION value="传媒分院">商业服务</OPTION> <OPTION value=管理分院>管理分院</OPTION>
                </select>
              <input type="submit" class="bt" name="subOK" value="搜索" onClick="search()"/>
            </td>
          </tr>
            </table>
      <table width="96%" border="0" cellspacing="0" cellpadding="6">
        <tr class="line bold"> 
          <td align="center">序号</td>
          <td align="center"> 课程名称</td>
          <td align="center"> 课程类别</td>
          <td align="center"> 开课部门</td>
          <td align="center"> 讲课教师</td>
          <td align="center"> 开课时间</td>
          <td align="center"> 学生人数</td>
          <td align="center"> 操作</td>
        </tr>
        <s:iterator value="#session.sCourses" id="c" status="index">
        	<s:if test="%{#c.tid!=#session.user.uid}">
        	<tr align='center'>
            	<td class='line2'><s:property value="#index.index"/></td>
            	<td class='line2'><s:property value="#c.title" /></td>
            	<td class='line2'><s:property value="#c.classType" /></td>
            	<td class='line2'><s:property value="#c.college" /></td>
            	<td class='line2'><s:property value="#c.teacher" /></td>
            	<td class='line2'><s:property value="#c.beginTime" /></td>
            	<td class='line2'><s:property value="#c.studentNumber" /></td>
            	<td class='line2'><button id=add onclick="add('<s:property value="#c.cid" />');">加入</button>
            	</td>
        	</tr>
        	</s:if>
        </s:iterator>
      </table>
	  </td>
  </tr>
</table>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	 function add(joinCourseId){
    	if(confirm("确认加入？")){
    		var path="<%=basePath%>courses/joinCourse.action";
			//alert(path);
			//alert(joinCourseId);
    		$.ajax({
    			type:"post",
    			url:path,
    			data:{joinCourseId:joinCourseId},
    			success:function(result){
    				alert(result);
    				location.reload() 
    			},
    			error:function(result){
    				alert(result);
    				location.reload();
    			}
    		});
    	}
    }
    function search(){
    	var sName =$("#txtCourseName").val();
    	var sTeacher =$("#txtCourseTeacher").val();
    	var sCollege =$("#txtCourseCollege").val();
    	var path="<%=basePath%>courses/searchCourse.action";
    	$.ajax({
    			type:"post",
    			url:path,
    			data:{titleSreach:sName,
    				  teacherSreach:sTeacher,
    				  collegeSreach:sCollege},
    			success:function(result){
    				alert(result);
    				location.reload() 
    			},
    			error:function(result){
    				alert(result);
    				location.reload();
    			}
    	});
    }
    
</script>
</html>