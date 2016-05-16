//
// 全局变量的定义
//
var MaxContentLength    = 800   // 允许输入的最大内容长度

//
// 窗体加载时运行
//
document.onkeydown = function EnterToTab() {
    if (event.keyCode == 13 && event.srcElement.type!='button' && event.srcElement.type!='submit' && event.srcElement.type!='file' && event.srcElement.type!='reset' && event.srcElement.type!='textarea' && event.srcElement.type!='') {
        event.keyCode = 9
    }
    if (trim(document.all("txtFullName").value).length == 0)
    {
        document.all["txtFullName"].focus();
    }
    // 检查输入的内容的长度
    document.all["txtContent"].onkeydown = CheckContent;
    document.onmousedown=click;
}

function click()
{
    X = event.clientX;
	Y = event.clientY;
	if(document.getElementById("Layer1").style.visibility == '')
	{
	    if(X < 165 || Y < 105 || X > 365 || Y > 372)
	    {
	        document.getElementById("Layer1").style.visibility = 'hidden';
            if(document.getElementById("ddlForum"))
            {
	            document.getElementById("ddlForum").style.visibility = '';
	        }
	    }
	}
}

//
// 检查输入的内容的长度
//
function CheckContent() 
{
    setTimeout("CheckNoteContent()", 100);
}

//
// 检查输入的内容的长度函数
//
function CheckNoteContent()
{
    var content = document.getElementById("txtContent");
    var contentLength = document.getElementById("txtContent").value.length;
    var count = MaxContentLength - contentLength;
    if(count < 0)
    {
        content.value = content.value.substr(0, MaxContentLength);
        return;
    }
    document.getElementById("lblPrompt").innerText = "提示信息:您还可以输入 " + count + " 个字符.";
}

//
// 关闭窗口
//
function Close(paramname, paramID)
{
    document.getElementById('txtCourseTypeID').value     = paramID;
	document.getElementById('txtCourseType').value       = paramname;
	document.getElementById('txtCourseTypeFullName').value = paramname;
	document.getElementById("Layer1").style.visibility   = 'hidden';
    if(document.getElementById("ddlForum"))
    {
	    document.getElementById("ddlForum").style.visibility = '';
	}
}

//
// 上传图片判断
//
function isPoth(paramControl)
{
    var x=document.getElementById(paramControl);
    if(!x||!x.value) return true;
    var path=/\.jpg$|\.bmp$|\.gif$|\.png$/i;
    var img = new Image();
    img.src = x.value;
    if(img.fileSize > 512000)
    {
        alert('请确定您上传的图片小于500K.');
        document.getElementById(paramControl).value = "";
		document.getElementById('fulAttachment').focus();
        return false;
    }
    if(!path.test(x.value))
    {
        alert('请确定您上传的图片是 .jpg/.gif/.bmp/.png 类型.');
        document.getElementById(paramControl).value = "";
		document.getElementById('fulAttachment').focus();
        return false;
    }
    return true;
}

//
// 检查页面输入
//
function CheckInput()
{
	// 名称
	if(document.getElementById('txtFullName').value.length == 0)
	{
		alert("请输入课程名称.");
		document.getElementById('txtFullName').focus();
		return false
	}
	// 分类
	if(document.getElementById('txtCourseType').value.length == 0 || document.getElementById('txtCourseTypeID').value.length == 0)
	{
		alert("请输入课程分类.");
		document.getElementById('txtCourseType').focus();
		return false
	}
	// 图片
	if(!isPoth(document.getElementById('fulAttachment').ID))
	{
		document.getElementById('fulAttachment').focus();
		return false
	}
//	// 注册人数
//	if(trim(document.getElementById('txtNum').value).length == 0)
//	{
//		alert("请输入课程注册人数.");
//		document.getElementById('txtNum').focus();
//		return false
//	}
//	// 注册人数
//	if(!isDigit(trim(document.getElementById('txtNum').value)))
//	{
//		alert("请输入正整数.");
//		document.getElementById('txtNum').focus();
//		return false
//	}
//	// 注册人数
//	if(trim(document.getElementById('txtNum').value) > paramMaxStudent)
//	{
//		alert("注册人数大于系统允许的最大人数.");
//		document.getElementById('txtNum').value = paramMaxStudent;
//		document.getElementById('txtNum').focus();
//		return false
//	}
	// 点数
	if(trim(document.getElementById('txtMoney').value).length == 0)
	{
		alert("请输入课程费用.");
		document.getElementById('txtMoney').focus();
		return false
	}
	// 费用
	if(!isDigit(trim(document.getElementById('txtMoney').value)))
	{
		alert("请输入正整数.");
		document.getElementById('txtMoney').focus();
		return false
	}
//	// 开课日期
//	if(trim(document.getElementById('dcStartDate').value).length == 0)
//	{
//		alert("请输入开始日期.");
//		document.getElementById('dcStartDate').focus();
//		return false
//	}
//	// 是否正确时间
//	if(trim(document.getElementById('txtStart').value).length > 0)
//	{
//	    if(!isTime(trim(document.getElementById('txtStart').value)))
//	    {
//		    document.getElementById('txtStart').focus();
//		    return false
//	    }
//	}
//	// 是否正确时间
//	if(trim(document.getElementById('txtEnd').value).length > 0)
//	{
//	    // 是否正确时间
//	    if(!isTime(trim(document.getElementById('txtEnd').value)))
//	    {
//		    document.getElementById('txtEnd').focus();
//		    return false
//	    }
//	}
//	// 结束时间大于开始时间
//	if(trim(document.getElementById('txtStart').value).length > 0 && trim(document.getElementById('txtEnd').value).length > 0)
//	{
//	    if(trim(document.getElementById('txtEnd').value) < trim(document.getElementById('txtStart').value))
//	    {
//		    alert("结束时间大于开始时间.");
//		    document.getElementById('txtEnd').focus();
//		    return false
//	    }
//	}
	return true;
}
