<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>密码修改</title>
<base href="<%=basePath%>">
<base target="_self" />
<link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery.js"></script>
   <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<<div align="center"> 
		<form action="users/updateAvatar.action" method="post" enctype="multipart/form-data">
		<div class="container">
   			<div class="row">
      			<div class="col-xs-6 col-sm-3"><label for="upload">上传头像:</label></div>
      			<div class="col-xs-6 col-sm-3"><img id=preview src="<%=path%>/users/getAvatar.action" class="img-circle" style="WIDTH: 150px; HEIGHT: 150px;"></div>      
   			</div>
			<hr>
   			<div class="row">
   				<div class="col-xs-6 col-sm-5"></div>
   				<div class="col-xs-6 col-sm-3"><input id=upload type="file" name="upload" onchange="javascript:setImagePreview();"></div>
   			</div>
   			<hr>
   			<div class="row">
   			<div class="col-xs-6 col-sm-3"></div>
   				<div class="col-xs-6 col-sm-3"><input type="submit" value="更新头像"> </div>
   			</div>
		<div class="container">
</body>
<script type="text/javascript">
		
	//下面用于图片上传预览功能
	function setImagePreview(avalue) {
		var docObj = document.getElementById("upload");

		var imgObjPreview = document.getElementById("preview");
		if (docObj.files && docObj.files[0]) {
			//火狐下，直接设img属性
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '150px';
			imgObjPreview.style.height = '150px';
			//imgObjPreview.src = docObj.files[0].getAsDataURL();
			//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		} else {
			//IE下，使用滤镜
			docObj.select();
			var imgSrc = document.selection.createRange().text;
			//图片异常的捕捉，防止用户修改后缀来伪造图片
			try {
				localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localImagId.filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
			} catch (e) {
				alert("您上传的图片格式不正确，请重新选择!");
				return false;
			}
			imgObjPreview.style.display = 'none';
			document.selection.empty();
		}
		return true;
	}
</script>

</html>
