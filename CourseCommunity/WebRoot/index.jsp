<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-datetimepicker.min.css"/ >
	<script src="<%=path %>/js/jquery.js"></script>
	<script src="<%=path %>/js/bootstrap-datetimepicker.min.js"></script>	
	
  </head>
  
  <body>
   <s:form action="uploadOne" method="post" enctype="multipart/form-data">
            <s:file name="file" label="文件1"></s:file>
            <s:file name="file" label="文件2"></s:file>
            <s:file name="file" label="文件3"></s:file>
            <s:file name="file" label="文件4"></s:file>
            <s:submit label="上传"/>
   </s:form>    
   
   <input size="16" type="text" value="2012-06-15" readonly class="form_datetime">
   <script type="text/javascript">
    $(".form_datetime").datetimepicker({
    
    format: 'yyyy-mm-dd',
    autoclose :true,
	todayBtn :true,
	minView :2,
	weekStart :1,
	linked :true
    });
	</script>    
  </body>
</html>
