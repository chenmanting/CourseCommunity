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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache"> 
<meta http-equiv="expires" content="0">   
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
          <td width="13%" align="center"> 用户名</td>
          <td width="10%" align="center"> 姓名</td>
          <td width="13%" align="center"> 学号</td>
          <td width="25%" align="center"> Email</td>
          <td width="11%" align="center">手机号码</td>
          <td width="7%" align="center"> 操作</td>
        </tr>
        <s:iterator value="#session.students" id="s" status="index">
        	<tr align='center'>
            	<td class='line2'><s:property value="#index.index"/></td>
            	<td class='line2'><s:property value="#s.username" /></td>
            	<td class='line2'><s:property value="#s.name" /></td>
            	<td class='line2'><s:property value="#s.number" /></td>
            	<td class='line2'><s:property value="#s.email" /></td>
            	<td class='line2'><s:property value="#s.telphone" /></td>
            	<td class='line2'>
            	<button id=quit onclick="quit('<s:property value="#s.uid" />')">移除</button>
            	</td>
        	</tr>
        </s:iterator>
        <tr align='center'><TD colspan="8">
	        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr class="line bold">
		    	<td>当前第<span id="currentPage"></span>页</td>
		    	<td>每页5条</td>
		       <td><button id=firstPage onclick="gotoFirstPage()">首页</button></td>
		       <td><button id=prePage onclick="gotoPrePage()">上一页</button></td>
		       <td><button id=nextPage onclick="gotoNextPage()">下一页</button></td>
		       <td><button id=lastPage onclick="gotoLastPage()">尾页</button></td>
		    </tr>
		    </table></TD>
        </tr>
      </table>
	  </td>
  </tr>
</table>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$("#currentPage").text("1");
	}); 
	
	function gotoFirstPage(){
		var path="<%=basePath%>upages/gotoPage.action";
		var pageNum = 1;
    	$.ajax({
    		type:"post",
    		url:path,
    		data:{pageNum:pageNum},
    		success:function(result){
    			$("#currentPage").text(1);
    			location.reload() 
    		},
    		error:function(result){
    			alert(result);
    		}
    	});
	}
	function gotoPrePage(){
		var path="<%=basePath%>upages/gotoPage.action";
		var pageNum =$("#currentPage").text();
    	pageNum--;
    	$.ajax({
    		type:"post",
    		url:path,
    		data:{pageNum:pageNum},
    		success:function(result){
    			if("isFirst" == result){
    				alert("已经是首页了")
    			}else{
    				var c =$("#currentPage").text();
    				c--;
    				$("#currentPage").text(c);
    				location.reload();
    			}
    		},
    		error:function(result){
    			alert(result);
    		}
    	});
	}
	function gotoNextPage(){
		var path="<%=basePath%>upages/gotoPage.action";
		var pageNum =$("#currentPage").text();
    	pageNum++;
    			
    	$.ajax({
    		type:"post",
    		url:path,
    		data:{pageNum:pageNum},
    		success:function(result){
    			if("isLast" == result){
    				alert("已经是尾页了")
    			}else{
    				var c =$("#currentPage").text();
    				c++;
    				$("#currentPage").text(c);
    				location.reload();
    			}
    		},
    		error:function(result){
    			alert(result);
    		}
    	});
	}
	
	function quit(id){
		var c ='<%=session.getAttribute("cid")%>';
		//alert(s);
		if(confirm("确认移除？")){
    			var path="<%=basePath%>courses/removeCourse.action";
				//alert(path);
    			$.ajax({
    				type:"post",
    				url:path,
    				data:{ruid:id, rcid:c},
    				success:function(result){
    					alert(result);
    					location.reload() 
    				},
    				error:function(result){
    					alert(result);
    				}
    			});
    		}
	}
</script>

</html>