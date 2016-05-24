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
<link href="css/personalstyle.css" rel="stylesheet" type="text/css">
<script src="js/common.js"></script>
</head>

<script language="JavaScript">
<!--
var g_selDept1;
var g_selDept2;
var Dept1s=new Array(
new Array("110000","信息分院"),
new Array("120000","机电分院"),
new Array("130000","外语分院"),
new Array("140000","法传分院")
);

var Dept2s=new Array(
new Array("110100","信息与计算科学"),
new Array("110200","计算机科学"),
new Array("110300","信息科学与工程"),
new Array("110400","自动化"),
new Array("120100","机械设计与制造"),
new Array("120200","机电工程"),
new Array("130100","科技英语"),
new Array("130200","日语"),
new Array("130300","德语"),
new Array("140101","法律"),
new Array("140201","传媒"),
new Array("140301","新闻")
);


function FillDept1s(selDept1, Dept1)
{
    selDept1.options[0]=new Option("请选择","");
    for(i=0;i<Dept1s.length;i++)
    {
        selDept1.options[i+1]=new Option(Dept1s[i][1],Dept1s[i][0]);
    }
    selDept1.options[0].selected=true;
    selDept1.length=i+1;
	if(Dept1.length > 0)
	{
		selDept1.value = Dept1
	}
}

function FillDept2s(selDept2,Dept1Code, paramDept2)
{
        if(Dept1Code=="110000"||Dept1Code=="120000")
             count=0;
        else
                {selDept2.options[0]=new Option("请选择",Dept1Code);
                count=1;}
    for(i=0;i<Dept2s.length;i++)
    {
        if(Dept2s[i][0].toString().substring(0,2)==Dept1Code.substring(0,2))
        {
            selDept2.options[count]=new Option(Dept2s[i][1],Dept2s[i][0]);
            count=count+1;
        }
    }
    selDept2.options[0].selected=true;
    selDept2.length=count;
	if(paramDept2 != null)
	{
		if(paramDept2.length > 0)
		{
			selDept2.value = paramDept2;
		}
	}
}

function Dept1_onchange(Dept2)
{
    FillDept2s(g_selDept2,g_selDept1.value,Dept2);
}

function InitDept2Select(selDept1,selDept2, Dept1, Dept2)
{
    g_selDept1=selDept1;
    g_selDept2=selDept2;
    selDept1.onchange=Function("Dept1_onchange("+Dept2+");");
    FillDept1s(selDept1, Dept1);
    Dept1_onchange(Dept2);
}

function InitDept2Select2(selDept1,selDept2,Dept2Code)
{
    InitDept2Select(selDept1,selDept2)
    for(i=0;i<selDept1.length;i++)
    {
        if(selDept1.options[i].value.substring(0,2)==Dept2Code.substring(0,2))
        {
            selDept1.options[i].selected=true;
        }
    }
    Dept1_onchange();
    for(i=0;i<selDept2.length;i++)
    {
        if(selDept2.options[i].value==Dept2Code)
        {
            selDept2.options[i].selected=true;
        }
    }
}

//-->
</script>
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
          <td><b>现在位置：课程查询</b></td>
        </tr>
      </table></td>
  </tr>
  <tr> 
    <td align="center" valign="top" bgcolor="#FFFFFF">
<table width="100%" border="0" cellpadding="0" cellspacing="0">
<form method="post" action="UICourseSearch.asp" name="form1" onSubmit="return goadmin(form1.ss.value)">
<input type=hidden name='ss' value=''>
	<tr>
    	<td height="40" align="center" class="font4">
		<input type="text" name="txtSearch" id="txtSearch" value="请输入关键字" onClick="if(this.value=='请输入关键字')this.value=''" style="width: 100px" /> &nbsp;
                          <select name="ddlSearchCategory">
							<option value="1" >搜索类型</option>
							<option value="2" >课程名称</option>
							<option value="3" >课程类别</option>
							<option value="4" >教师</option>
							<option value="5" >关键字</option>
                          </select>&nbsp;&nbsp;
                          开课分院：
                          <select id="dept1" size="1" name="dept1">
                            <option selected></option>
                          </select>&nbsp;&nbsp;
                          系别：
                          <select id="dept2" name="dept2">
                            <option selected></option>
                          </select>&nbsp;
              <script language="javascript">
			InitDept2Select(document.form1.dept1,document.form1.dept2, "", "");
		</script>
              <input type="submit" class="bt" name="subOK" value="搜索" onClick="javascript:form1.ss.value='sousuo'"/>
            </td>
          </tr></form>
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
        <s:iterator value="#session.allCourses" id="c" status="index">
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
    				}
    			});
    		}
    	}
</script>
</html>