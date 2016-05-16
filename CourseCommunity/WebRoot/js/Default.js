//
// 弹出窗口打开方法
//
function openStdDlg(sPath, oArgs, iX, iY)
{
	return window.showModalDialog(sPath, oArgs, "dialogWidth:" + iX + "px;dialogHeight:" + iY + "px;help:0;status:0;scroll:0;center:1");
}

//
// 按下回车时转换为Tab键
//
function EnterToTab()
{
	if (event.keyCode == 13 && event.srcElement.type!='button' && event.srcElement.type!='submit' && event.srcElement.type!='file' && event.srcElement.type!='reset' && event.srcElement.type!='textarea' && event.srcElement.type!='')
	{
		event.keyCode = 9
	}
}

//
// 是否有选中的复选框
//
function CheckSelected(paramI)
{
	var objForm = document.forms[paramI];
	var objLen = objForm.length;
	var selected = false;
	for (var i = 0; i < objLen; i++)
	{
		if (objForm.elements[i].type == "checkbox")
		{
			if (objForm.elements[i].checked)
			{
			    selected = true;
			    break;
			}
		}
	}
	return selected;
}

function CheckItem(checkedControlID)
{
    document.getElementById(checkedControlID).checked = IsSelectdAll("from1");
}

function CheckColItem(checkedControlID, checkGroupName)
{
    document.getElementById(checkedControlID).checked = IsSelectdColAll(checkedControlID, checkGroupName);
}

//
// 全选复选框
//
function CheckAll(checkedControlID)
{
    CheckColAll(checkedControlID, "chkSelected");
}

function CheckColAll(checkedControlID, checkGroupName)
{
    // 在哪个form里的控件
    var targetForm = document.form1;
    var checkedControl = document.getElementById(checkedControlID);
    for (var i = 0; i < targetForm.length; i++)
    {
        var targetControl = targetForm.elements[i];
        if (targetControl.type == "checkbox" && targetControl.name.substr((targetControl.name.length-checkGroupName.length),(targetControl.name.length-1)) == checkGroupName)
        {
            // 不可以把当前控件的状态给改变了 
            if (targetControl.id != checkedControlID)
            {
	            targetControl.checked = checkedControl.checked;
            }
        }
    }
}

//
// 按钮全选
//
function ButtonCheckAll(checkedControlID)
{
    var controlCheck = document.getElementById(checkedControlID);
    controlCheck.checked = ! controlCheck.checked;
    // 全选复选框
    CheckAll(checkedControlID);
    return false;
}

//
// 是否全部选中了
//
function IsSelectdAll(checkedControlID)
{
    return IsSelectdColAll(checkedControlID, "chkSelected")
}

//
// 是否全部选中了
//
function IsSelectdColAll(checkedControlID, checkGroupName)
{
    var returnValue = true;
    var controlCheck = document.getElementById(checkedControlID);
    var objForm = document.form1;
    var objLen = objForm.length;
    var i = 0;
    for (var iCount = 0; iCount < objLen; iCount++)
    {
        var objType = objForm.elements[iCount];
        if(objType.type == "checkbox" && objType.name.substr((objType.name.length-checkGroupName.length),(objType.name.length-1)) == checkGroupName)
        {
            if(!objType.checked)
            {
               i += 1;
               break;
            }
        }
    }
    if(i > 0)
    {
        returnValue = false;
    }
    return returnValue;
}

//
// 是否选中了任何一个
//
function IsSelectdAnyOne()
{
    var returnValue = false;
    var objForm = document.form1;
    var objLen = objForm.length;
    var i = 0;
    for (var iCount = 0; iCount < objLen; iCount++)
    {
        var objType = objForm.elements[iCount];
        if(objType.type == "checkbox" && objType.name.substr((objType.name.length-11),(objType.name.length-1)) == "chkSelected")
        {
            if(objType.checked)
            {
               i += 1;
               break;
            }
        }
    }
    if(i > 0)
    {
        returnValue = true;
    }
    return returnValue;
}

//
// 检查至少选择一条记录检查
//
function CheckSelectAnyOne(paramConfirm)
{
    // 是否选中了任何一个
    if(!IsSelectdAnyOne())
    {
        alert("提示信息:请至少选择一项.");
        return false;   
    }
    else
    {
        if(paramConfirm.length > 0)
        {
            return confirm(paramConfirm);
        }
        else
        {
            return true;
        }
    }
}

function InputCheck(strParam, paramStr)
{
    return CheckSelectAnyOne(strParam, paramStr)
}

//
// 选择单个CheckBox
//
function SelectOne(tempControl)
{
    // 将除头模板中的其它所有的CheckBox取反
    var theBox = tempControl;
    xState = theBox.checked;    
    elem = theBox.form.elements;
    for(i = 0; i < elem.length; i++)
    {
        if(elem[i].type == "checkbox" && elem[i].id != theBox.id)
        {
            elem[i].checked = false;
        }
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
// 验证输入数据的格式的合法性
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
// 数字验证
//
function VerifyNumeric(paramTargetString) 
{
	var numeric = paramTargetString; 
	var pattern = /^[+-]?[0-9.]*$/; 
	flag = pattern.test(numeric);
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
// 判断是否为日期
//
function IsDate(paramTargetString) 
{
    return true;
}

//
// 检查输入的有效性
//
function checkPredetermineEditByCategory(paramID)
{	
	var objMoney = document.getElementById(paramID);
	// 若是空的,没有问题的
	if (objMoney.value == "")
	{
		return true;
	}
	if(objMoney.value >= -99999999.99 && objMoney.value<99999999.99)
	{
	    return true;
	}
	else
	{
		alert("提示信息:请输入 -99999999.99 至 99999999.99 之间的数字");
		objMoney.value="";
		objMoney.focus();
		return false;
	}
}

//
// 取消(弹出窗口)
//
function Cancel()
{
	window.returnValue = null;
	window.close();
}

//
// 是否时间格式
//
function isTime(str)
{
    var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
    if(a == null)
    {
        alert("请输入正确的时间格式");
        return false;
    }
    if (a[1]>24 || a[3]>60 || a[4]>60)
    {
        alert("请输入正确的时间格式");
        return false;
    }
    return true;
}

//
// 身份证验证
function checkIdcard(idcard)
{ 
    var Errors=new Array( 
    "验证通过!", 
    "身份证号码位数不对!", 
    "身份证号码出生日期超出范围或含有非法字符!", 
    "身份证号码校验错误!", 
    "身份证地区非法!" 
    ); 
    var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}  
    var idcard,Y,JYM; 
    var S,M; 
    var idcard_array = new Array(); 
    idcard_array = idcard.split(""); 
    //地区检验 
    if(area[parseInt(idcard.substr(0,2))]==null) return Errors[4]; 
    //身份号码位数及格式检验 
    switch(idcard.length){ 
    case 15: 
    if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){ 
    ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性 
    } else { 
    ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性 
    } 
    if(ereg.test(idcard)) return Errors[0]; 
    else return Errors[2]; 
    break; 
    case 18: 
    //18位身份号码检测 
    //出生日期的合法性检查  
    //闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9])) 
    //平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8])) 
    if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){ 
    ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式 
    } else { 
    ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式 
    } 
    if(ereg.test(idcard)){//测试出生日期的合法性 
    //计算校验位 
    S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7 
    + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9 
    + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10 
    + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5 
    + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8 
    + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4 
    + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2 
    + parseInt(idcard_array[7]) * 1  
    + parseInt(idcard_array[8]) * 6 
    + parseInt(idcard_array[9]) * 3 ; 
    Y = S % 11; 
    M = "F"; 
    JYM = "10X98765432"; 
    M = JYM.substr(Y,1);//判断校验位 
    if(M == idcard_array[17]) return Errors[0]; //检测ID的校验位 
    else return Errors[3]; 
    } 
    else return Errors[2]; 
    break; 
    default: 
    return Errors[1]; 
    break; 
    } 
}

//
// 验证是否是电话
//
function Telephone(s)
{ 
    var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
    if (!patrn.exec(s))
    {
        return false;
    }
    else
    {
        return true; 
    }
}