<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<HTML>
<HEAD><TITLE>信计课程社区</TITLE>
<META http-equiv=Content-Type content="text/html; charset=GBK">
<LINK href="css/style.css" type=text/css rel=stylesheet>
<SCRIPT src="js/common.js"></SCRIPT>
<SCRIPT src="js/Top.js"></SCRIPT>
</HEAD>
<BODY onload=NowDate() >
<FORM name=form1 action=# method=post>
<TABLE class=per_bg height=85 cellSpacing=0 cellPadding=0 width="100%" bgColor=#ffffff border=0>
  <TBODY>
  <TR>
    <TD align=middle width=210>
      <TABLE height=55 cellSpacing=0 cellPadding=0 width=160 border=0>
        <TBODY>
        <TR>
          <TD vAlign=top>
            <img src="images/logo.gif" >
          </TD></TR></TBODY></TABLE></TD>
    <TD vAlign=top>
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD width=32><IMG height=39 src="images/per_01.gif" width=32></TD>
          <TD background=images/per_02.gif colSpan=2>
            <TABLE height=22 cellSpacing=0 cellPadding=0 width="100%" border=0>
            <TBODY>
              <TR>
                <TD class=casety vAlign=top><LABEL id=show>时间</LABEL></TD>
                <TD vAlign=center align=middle width=120>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                      <TD width=50><A 
                        href="javascript:window.parent.location.href='<%=path%>/index.jsp'"><IMG 
                        height=11 src="images/per_home.gif" width=38 
                        border=0></A></TD>
                      <TD><A target="_parent" href="<%=path%>/users/User_logout.action?username=cmt"><IMG 
                        height=11 src="images/per_quit.gif" width=37 
                        border=0></A></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          <TD>&nbsp;</TD>
          <TD height=30><B>${user.name }
              <LABEL id=time>时间</LABEL></B></TD>
          <TD><A href="/MessageList.aspx" target=Main>
            <IFRAME id=message style="OVERFLOW: hidden; BACKGROUND-COLOR: transparent" align=middle 
                src="#" frameBorder=0 width=110 height=19 allowTransparency scrolling="no">
            </IFRAME></A></TD>
        </TR>
        </TBODY>
      </TABLE>
    </TD></TR></TBODY>
</TABLE>
</FORM>
</BODY>
</HTML>
