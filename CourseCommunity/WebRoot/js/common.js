//
// 弹出窗口打开方法
//
function openStdDlg(sPath, oArgs, iX, iY)
{
	return window.showModalDialog(sPath, oArgs, "dialogWidth:" + iX + "px;dialogHeight:" + iY + "px;help:0;status:0;scroll:0;center:1");
}

//
// 验证Email地址
//
function VerifyMailAddress(paramTargetString) 
{
	var email = paramTargetString; 
	var pattern = /^([a-zA-Z0-9._-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/; 
	flag = pattern.test(email);
	if(flag)
	{
		return true;
	}
	else
	{
		return false;
	}
}

//
// 检查字符串长度
//
function checkVal(s)
{
    var k = 0;
    for(var i=0;i<s.length;i++)
    {
        if(s.charCodeAt(i) > 255)
        {
            k += 2;
        }
        else
        {
            k += 1;
        }
    }
    return k;
}

//
// 验证中文
//
function CheckChinese(str)
{
    return /[\u4E00-\u9FA0]/.test(str);
}

//
// 上传图片判断
//
function isPoth(paramControl, paramImage)
{
    var x=document.form1(paramControl);
    if(!x||!x.value) return true;
    var path=/\.jpg$|\.bmp$|\.gif$/i;
    var img = new Image();
    img.src = x.value;
    if(img.fileSize > 102400)
    {
        alert('请确定您上传的图片小于100K.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    if(path.test(x.value))
    {
        document.getElementById(paramImage).src = x.value;
    }
    else
    {		        
        alert('请确定您上传的图片是 .jpg/.gif/.bmp/.png 类型.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    return true;
}

//
// 上传图片判断
//
function isDPoth(paramControl, paramImage1, paramImage2)
{
    var x=document.form1(paramControl);
    if(!x||!x.value) return true;
    var path=/\.jpg$|\.bmp$|\.gif$/i;
    var img = new Image();
    img.src = x.value;
    if(img.fileSize > 102400)
    {
        alert('请确定您上传的图片小于100K.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    if(path.test(x.value))
    {
        document.getElementById(paramImage1).src = x.value;
        document.getElementById(paramImage2).src = x.value;
    }
    else
    {
        alert('请确定您上传的图片是 .jpg/.gif/.bmp/.png 类型.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    return true;
}

//
// 上传图片判断
//
function isPhoto(paramControl)
{
    var x=document.form1(paramControl);
    if(!x||!x.value) return true;
    var path=/\.jpg$|\.bmp$|\.gif$/i;
    var img = new Image();
    img.src = x.value;
    if(img.fileSize > 102400)
    {
        alert('请确定您上传的图片小于100K.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    if(!path.test(x.value))
    {
        alert('请确定您上传的图片是.jpg/.gif/.bmp/.png 类型.');
        document.getElementById(paramControl).value = "";
        return false;
    }
    return true;
}

//
// 验证电话号码
//
function CheckPhone(str)
{
    return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/.test(str);
}

//
// 验证日期
//
function IsDate(str)
{
    return /[\d]{4}-[\d]{2}-[\d]{2}/.test(str);
}

//
// 截取字符串
//
function getLength(str, paramLength)
{ 
    var tmp = 0;
    var len = 0;
    var okLen = 0
    for(var i=0;i < paramLength; i++)
    {
        if(str.charCodeAt(i) > 255)
        {
            tmp += 2;
        }
        else
        {
            len += 1;
        }
        okLen += 1
        if(tmp + len == paramLength) 
        {
            return (str.substring(0,okLen));
            break;
        }
        if(tmp + len > paramLength)
        {
            return (str.substring(0,okLen - 1) + " "); 
            break;
        }
    }
}
//
// 校验是否全由数字组成 
//
function isDigit(s)
{
    var patrn=/^[0-9]{1,20}$/;
    if (!patrn.exec(s))
    {
        return false;
    }
    return true;
}

//
// 检查输入金额格式
//
function CheckMoney(paramID)
{	
	var objMoney = document.getElementById(paramID);
	// 若是空的,没有问题的
	if (objMoney.value == "")
	{
		return true;
	}
	if(objMoney.value > 0 && objMoney.value<99999999.99)
	{
	    return true;
	}
	else
	{
		alert("请输入 0 至 99999999.99 之间的数字");
		objMoney.value="";
		objMoney.focus();
		return false;
	}
}

//
// 提示信息
//
function confirmMessage(paramMessage, paramUrl)
{
	if(confirm(paramMessage))
	{
		window.location.href = paramUrl;
	}
}

//
// 去左边的空格
//
function rtrim(paramValue)
{
    var returnValue = paramValue + "";
    while(returnValue.charAt(returnValue.length - 1) == " ")
    {
        returnValue = returnValue.substr(0, returnValue.length - 1);
    }
	return returnValue;
}

//
// 去右边的空格
//
function ltrim(paramValue)
{
    var returnValue = paramValue + "";
    while(returnValue.charAt(0) == " ")
    {
        returnValue = returnValue.substr(1);
    }
    return returnValue;
}

//
// 去掉两边的空格
//
function trim(paramValue)
{
    var returnValue = paramValue + "";
    if(returnValue == " " || returnValue == "undefined" || returnValue == "null")
    {
        returnValue = "";
    }
    else
    {
        returnValue = ltrim(rtrim(paramValue));
    }
    return returnValue;
}

//
// 检查一个页面是否是父页面
//
function Parent()
{
	if(window.location == window.parent.location)
	{
		window.location.href = "index.htm";
	}
	else
	{
		window.parent.location.href = "index.htm";
	}
}

//
// 检查一个页面是否是父页面
//
function Parents()
{
	if(window.location == window.parent.location)
	{
		window.location.href = "../index.htm";
	}
	else
	{
		window.parent.location.href = "../index.htm";
	}
}