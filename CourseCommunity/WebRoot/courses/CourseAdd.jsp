<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <title>我的网络课堂</title>
    <base target="_self" />
    <base href="<%=basePath%>">
    <script language='javascript' src='js/Default.js'></script>
    <script language='javascript' src='js/CourseAdd.js'></script>
    <link rel="stylesheet" type="text/css" href="css/personalstyle.css">
</head>
<body>
<form name="form1" method="post" action="courses/addCourse.action" id="form1" enctype="multipart/form-data">

<script type="text/javascript">
//<![CDATA[
var theForm = document.forms['form1'];
if (!theForm) {
    theForm = document.form1;
}
//]]>
</script>
        <table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0"
            class="case">
            <tr>
                <td height="27" background="images/per_case_bg.gif"
                    bgcolor="#FFFFFF">
                    <table width="100%" border="0" cellspacing="5" cellpadding="0">
                        <tr><td><b>现在位置：开设课程</b></td></tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td valign="top" bgcolor="#FFFFFF">
                    <table border="0" width="100%" cellspacing="5" cellpadding="0">
                        <tr>
                            <td width="13%" align="right">课程名称:&nbsp;</td>
                            <td width="27%"><input name="title" type="text" maxlength="30" id="txtFullName" tabindex="2" class="input" style="width:200px;" /></td>
                            <td width="60%">限30个字符以内。</td>
                        </tr>
                        <tr>
                            <td align="right">课程类别:&nbsp;</td>
                            <td><select name="classType" type="text" maxlength="30" id="txtCourseType" tabindex="3" class="input" onFocus="" style="width:200px;" >
                            	<OPTION value="" selected>请选择</OPTION> <OPTION value="信息与计算科学">信息与计算科学</OPTION> 
                            	<OPTION value="计算机科学">计算机科学</OPTION> <OPTION value="信息科学与工程">信息科学与工程</OPTION> 
                            	<OPTION value="自动化">自动化</OPTION> <OPTION value="机械设计与制造">机械设计与制造</OPTION> 
              					<OPTION value="机电工程">机电工程</OPTION> <OPTION value=科技英语>科技英语</OPTION>
              					<OPTION value="日语">日语</OPTION> <OPTION value="德语">德语</OPTION> 
                            	<OPTION value="法律">法律</OPTION> <OPTION value="传媒">传媒</OPTION> 
              					<OPTION value="新闻">新闻</OPTION> <OPTION value=管理>管理</OPTION>
                            	</select>
                            <td>请填写课程类别。</td>
                        </tr>
                        <tr>
                            <td align="right">开课部门:&nbsp;</td>
                            <td><select name="college" type="text" maxlength="30" id="txtCourseCollege" tabindex="3" class="input" onFocus="" style="width:200px;" >
                            	<OPTION value="" selected>请选择</OPTION> <OPTION value="信息分院">信息分院</OPTION> 
                            	<OPTION value="机电分院">机电分院</OPTION> <OPTION value="外语分院">外语分院</OPTION> 
                            	<OPTION value="法传分院">法传分院</OPTION> <OPTION value="经济分院">经济分院</OPTION> 
              					<OPTION value="传媒分院">商业服务</OPTION> <OPTION value=管理分院>管理分院</OPTION>
                            	</select>
                            <td>请选择分类。</td>
                        </tr>
                        
                        <tr>
                            <td align="right">关键字:&nbsp;</td>
                            <td><input name="keyword" type="text" maxlength="30" id="txtCourseKey" tabindex="4" class="input" style="width:200px;" /></td>
                            <td>关键字是为了让别人尽可能快的搜到您的课程。</td>
                        </tr>
                        <tr>
                            <td align="right">是否公开:&nbsp;</td>
                            <td><input id="rbtnPublic" type="radio" name="isPublic" value="true" checked="checked" tabindex="6" /><label for="rbtnPublic">公开</label>&nbsp;
                                <input id="rbtnUnPublic" type="radio" name="isPublic" value="false" tabindex="7" /><label for="rbtnUnPublic">不公开</label></td>
                            <td>
                                不公开的课程在查询中不显示。</td>
                        </tr>
                        <tr>
                            <td align="right">是否审核:&nbsp;</td>
                            <td><input id="rbtnUnAudit" type="radio" name="isCheck" value="true" checked="checked" tabindex="8" /><label for="rbtnUnAudit">否</label>
                                &nbsp; &nbsp;&nbsp;
                                <input id="rbtnAudit" type="radio" name="isCheck" value="false" tabindex="9" /><label for="rbtnAudit">是</label></td>
                            <td>
                                如选择是，则学生注册课程后，须教师审核才能有效，默认为不审核。</td>
                        </tr>
                        <tr>
                            <td align="right">课程备注:&nbsp;</td>
                            <td><input name="notes" type="text" value="0" maxlength="30" id="txtMoney" tabindex="11" class="input" style="width:200px;" />
                            <span id="lblMessage"> </span></td>
                            <td><span id="lblMoney" style="color:Red;">请谨慎！</span></td>
                        </tr>
                        
                        
                        <tr>
                            <td valign="top" align="right"> 课程介绍:&nbsp;<br/>
                            (限800字内)&nbsp;</td>
                            <td colspan="2">
                                <textarea name="briefIntro" rows="2" cols="20" id="txtContent" tabindex="17" class="input" style="height:105px;width:100%;"></textarea></td>
                        </tr>
                        <tr>
                            <td>&nbsp;
                                </td>
                            <td colspan="2">
                                <span id="lblPrompt" style="color:Red;"> </span></td>
                        </tr>
                        <tr>
                            <td align="center">&nbsp;</td>
                            <td colspan="3">
                                <input type="submit" name="btnSave" value="保存(S)" id="btnSave" accesskey="S" tabindex="18" class="bt" />
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
        <input type="hidden" name="txtChangeRate" id="txtChangeRate" value="10000" />
        <input type="hidden" name="txtChange" id="txtChange" value="100" />
        <input type="hidden" name="txtMaxStudent" id="txtMaxStudent" value="100" />
</form>
</body>
</html>
