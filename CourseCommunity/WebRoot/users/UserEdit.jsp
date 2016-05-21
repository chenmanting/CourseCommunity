<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>
<HTML>
<HEAD><TITLE>个人信息</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<SCRIPT language=javascript src="js/Default.js"></SCRIPT>

<LINK href="css/personalstyle.css" type=text/css rel=stylesheet>

<s:head theme="xhtml"/>  
<sx:head parseContent="true"/>   

<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap-datetimepicker.min.css"/ >

</HEAD>
<BODY>
<FORM id=form1 name=form1 action="<%=path%>/users/User_editUserinfo.action" method=post encType=multipart/form-data>
<TABLE class=case height="100%" cellSpacing=0 cellPadding=0 width="98%" align=center border=0>
  <TBODY>
  <TR>
    <TD background=images/per_case_bg.gif bgColor=#ffffff height=27>
      <TABLE cellSpacing=5 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD><B>现在位置 &gt; 个人信息</B></TD></TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD vAlign=top bgColor=#ffffff>
      <TABLE cellSpacing=5 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD width=81 align="right">真实姓名:</TD>
          <TD width="356"><INPUT class=input id=txtFullName tabIndex=1 maxLength=100 
            name=name value="${user.name}"></TD>
          <TD width="159"><INPUT id=chkFullNameState tabIndex=21 type=checkbox 
            name=check value="0"><LABEL for=chkFullNameState>显示</LABEL></TD>
          <TD width="262"></TD></TR>
        <TR>
          <TD align="right" noWrap>性别:</TD>
          <TD><INPUT id=rbtnmale tabIndex=2 type=radio CHECKED value=男 
            name=sex><LABEL for=rbtnmale>男</LABEL> <INPUT id=rbtnfemale 
            tabIndex=3 type=radio value=女 name=Sex><LABEL 
            for=rbtnfemale>女</LABEL></TD>
          <TD><INPUT id=chkSexState tabIndex=22 type=checkbox CHECKED 
            name=check value="1"><LABEL for=chkSexState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>学号(工号):</TD>
          <TD><INPUT class=input id=txtMSN tabIndex=14 maxLength=100 
            name=number value="${user.number}"></TD>
          <TD><INPUT id=chkMSNState tabIndex=28 type=checkbox CHECKED 
            name=check value="2"><LABEL for=chkMSNState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>出生日期:</TD>
          <TD>
            <TABLE style="WIDTH: 150px; HEIGHT: 20px" cellSpacing=0 
            cellPadding=0 border=0>
              <TBODY>
              <TR>
                <TD><input size="16" type="text" id=mBirthday name=birthday value="2012-06-15" readonly class="form_datetime"></TD>
              </TR></TBODY></TABLE></TD>
          <TD><INPUT id=chkBirthdayState tabIndex=23 type=checkbox 
            name=check value="3"><LABEL for=chkBirthdayState>显示</LABEL></TD>
          <TD></TD></TR>
           -->
        <TR>
          <TD align="right" noWrap>籍贯:</TD>
          <TD><INPUT class=input id=location tabIndex=1 maxLength=100 
            name=location value="${user.location }"></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>用户类型:</TD>
          <TD><INPUT id=userTeacher tabIndex=6 type=radio CHECKED 
            value=teacher name=type>
         	<LABEL for=userTeacher> 教师</LABEL>
            <INPUT id=userStudent tabIndex=7 type=radio value=student 
            name=type>
            <LABEL for=userStudent>学生</LABEL> <INPUT 
            id=userManager tabIndex=8 type=radio value=manager 
            name=type>
            <LABEL for=userManager>管理</LABEL></TD>
          <TD></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>Email:</TD>
          <TD><INPUT class=input id=txtEmail tabIndex=10 maxLength=100 name=email value="${user.email }"> </TD>
          <TD><INPUT id=chkEmailState tabIndex=24 type=checkbox 
            name=check value="4"><LABEL for=chkEmailState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>QQ:</TD>
          <TD><INPUT class=input id=txtOICQ tabIndex=13 maxLength=100 
            name=qq value="${user.qq }"> </TD>
          <TD><INPUT id=chkOICQState tabIndex=27 type=checkbox CHECKED 
            name=check value="5"><LABEL for=chkOICQState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>固定电话:</TD>
          <TD><INPUT class=input id=txtTelephone tabIndex=15 maxLength=100 
            name=telphone value="${user.telphone }"> </TD>
          <TD><INPUT id=chkTelephoneState tabIndex=29 type=checkbox 
            name=check value="6"><LABEL for=chkTelephoneState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>移动电话:</TD>
          <TD><INPUT class=input id=txtMobile tabIndex=16 maxLength=100 
            name=mobilephone value="${user.mobilephone }"> </TD>
          <TD><INPUT id=chkMobileState tabIndex=30 type=checkbox 
            name=check value="7"><LABEL for=chkMobileState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>工作单位:</TD>
          <TD><INPUT class=input id=txtPost tabIndex=11 maxLength=6 
            name=company value="${user.company }"> </TD>
          <TD><INPUT id=chkPostState tabIndex=25 type=checkbox 
            name=check value="8"><LABEL for=chkPostState>显示</LABEL></TD>
          <TD></TD></TR>
        <TR>
          <TD align="right" noWrap>职业:</TD>
          <TD><SELECT class=input id=ddlWork style="WIDTH: 136px" tabIndex=18 
            name=occupation> <OPTION value="" selected>请选择</OPTION> <OPTION 
              value="企事业单位">企事业单位</OPTION> <OPTION value="金融机构">金融机构</OPTION> 
              <OPTION value="文化艺术">文化艺术</OPTION> <OPTION 
              value="广告／公关">广告／公关</OPTION> <OPTION value="新闻媒体">新闻媒体</OPTION> 
              <OPTION value="商业服务">商业服务</OPTION> <OPTION 
              value="生活服务">生活服务</OPTION> <OPTION value="社会团体">社会团体</OPTION> 
              <OPTION value="娱乐／影视">娱乐／影视</OPTION> <OPTION 
              value="公务员">公务员</OPTION> <OPTION value="农林渔">农林渔</OPTION> 
              <OPTION value="法律／咨询">法律／咨询</OPTION> <OPTION 
              value="旅游业">旅游业</OPTION> <OPTION value="IT业">IT业</OPTION> 
              <OPTION value="通讯业">通讯业</OPTION> <OPTION 
              value="运动／休闲">运动／休闲</OPTION> <OPTION value="制造业">制造业</OPTION> 
              <OPTION value="自由职业">自由职业</OPTION></SELECT></TD>
          <TD><INPUT id=chkWorkState tabIndex=32 type=checkbox 
            name=check value="9"><LABEL for=chkWorkState>显示</LABEL></TD>
          <TD></TD></TR>
        <!-- 
        <TR>
          <TD align="right">个人头像:</TD>
          <TD><IMG id=preview 
            style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; WIDTH: 150px; HEIGHT: 150px; BORDER-RIGHT-WIDTH: 0px" 
            src="images/none.gif"><BR>
            <file name=mAvatar tabIndex=19 onchange="javascript:setImagePreview();"></file>
            
            <INPUT class=input id=avatar 
            tabIndex=19 type=file name=mAvatar  onchange="javascript:setImagePreview();"> 
            
            </TD>
          <TD><INPUT id=chkPhotoState tabIndex=33 type=checkbox CHECKED 
            name=chkPhotoState><LABEL for=chkPhotoState>显示</LABEL></TD>
          <TD></TD></TR>
           -->
        <TR>
          <TD vAlign=top align="right" noWrap>个人介绍:</TD>
          <TD><TEXTAREA class=input id=txtDescription style="WIDTH: 100%; WORD-BREAK: break-all; HEIGHT: 120px" tabIndex=20 name=introduction></TEXTAREA> 
          </TD>
          <TD><INPUT id=chkPhotoState tabIndex=33 type=checkbox CHECKED 
            name=check value="10"><LABEL for=chkPhotoState>显示</LABEL></TD>
          <TD noWrap></TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD colSpan=3><SPAN id=lblPrompt 
        style="COLOR: red">&nbsp;</SPAN></TD></TR>
        <TR>
          <TD align=middle>&nbsp;</TD>
          <TD colSpan=3><INPUT class=bt id=btnSave accessKey=S tabIndex=35 type=submit value=保存(S) name=btnSave> 
            <INPUT class=bt id=btnBack accessKey=B tabIndex=36 type=submit value=返回(B) name=btnBack> 
          </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
</FORM>
</BODY>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="<%=path %>/js/bootstrap-datetimepicker.min.js"></script>	
<script type="text/javascript">
	// 日历选择器
	$(".form_datetime").datetimepicker({
    	format: 'yyyy-mm-dd',
    	autoclose :true,
		todayBtn :true,
		minView :2,
		weekStart :1,
		linked :true
    });

	$(document).ready(function(){
		//自动设置用户性别属性
		var s = "${user.sex}";
		if(s == "女"){
			//alert("is female")
			$('#rbtnfemale').attr("checked","checked");
		}
		//自动设置出生日期属性
		var b = "${user.birthday}";
		//alert(b);
		if(b != undefined && b != "" & b != null){
			//alert("kkkk");
			$("#mBirthday").val(b);
		}
		
		//自动设置用户类别属性
		var type = "${user.type}";
		//alert(type);
		if(type=="student"){
			$('#userStudent').attr("checked","checked");
		}else if(type=="manager"){
			$('#userManager').attr("checked","checked");
		}
		
		//自动设置用户职业属性
		var occupation = "${user.occupation}";
		//alert(occupation);
		$('#ddlWork').val(occupation);
		
		//自动设置个人介绍属性
		var introduction = "${user.introduction}";
		//alert(introduction);
		$('#txtDescription').val(introduction);
		
		//自动设置隐藏显示属性
		var display = "${user.display}";
		//alert(display);
		//$("input[name='check']").removeAttr("checked"); 
		var i=0;
		$("input[name='check']").each(function(){ 
			if(display[i]=='1'){
				$(this).attr("checked","checked");
				//alert($(this).val());
			}else{
				$(this).removeAttr("checked");
			}
			//alert(display[i]);
			++i;
		}); 
		
	});
</script>
</HTML>
