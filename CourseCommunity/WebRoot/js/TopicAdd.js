//
// 全局变量的定义
// 
var MaxTitleLength      = 50    // 允许输入的最大主题长度
var MaxContentLength    = 800   // 允许输入的最大内容长度

//
// 窗体加载时运行
//
document.onkeydown = function EnterToTab() {
    if (event.keyCode == 13 && event.srcElement.type!='button' && event.srcElement.type!='submit' && event.srcElement.type!='file' && event.srcElement.type!='reset' && event.srcElement.type!='textarea' && event.srcElement.type!='') {
        event.keyCode = 9
    }
    if (trim(document.all("txtTitle").value).length == 0)
    {
        document.all["txtTitle"].focus();
    }
    // 检查输入的内容的长度
    document.all["txtContent"].onkeydown = CheckContent;
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
// 验证码图片
//
function change(paramimg)
{
    document.getElementById("CheckCode").src = "../CheckImage/CheckImage.aspx";
}

//
// 检查页面数据的有效性
//
function CheckInput()
{
    var returnValue = true;
    // 检查主题
    if (trim(document.getElementById("txtTitle").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请输入主题.";
        alert("提示信息:请输入主题.");
        document.all["txtTitle"].focus();
        return false;
    }
    // 检查主题长度
    if (trim(document.getElementById("txtTitle").value).length > MaxTitleLength)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:主题长度已超过" + MaxTitleLength + "个字符.";
        alert("提示信息:主题长度已超过" + MaxTitleLength + "个字符.");
        document.all["txtTitle"].focus();
        return false;
    }
    // 检查类别
    if (trim(document.getElementById("ddlCategory").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请选择类别.";
        alert("提示信息:请选择类别.");
        document.all["ddlCategory"].focus();
        return false;
    }
    // 检查内容
    if (trim(document.getElementById("txtContent").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请输入内容.";
        alert("提示信息:请输入内容.");
        document.all["txtContent"].focus();
        return false;
    }
    // 检查内容长度
    if (trim(document.getElementById("txtContent").value).length > MaxContentLength)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:内容长度已超过" + MaxContentLength + "个字符.";
        alert("提示信息:内容长度已超过" + MaxContentLength + "个字符.");
        document.all["txtContent"].focus();
        return false;
    }
    // 检查验证码
    if (trim(document.getElementById("txtCheckCode").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请输入验证码.";
        alert("提示信息:请输入验证码.");
        document.all["txtCheckCode"].focus();
        return false;
    }
    return returnValue;
}

//
// 清空页面内容
//
function ClearForm()
{
    document.getElementById("txtTitle").value       = "";
    document.getElementById("txtContent").value     = "";
    document.getElementById("lblPrompt").innerText  = "";
    document.getElementById("txtCheckCode").value   = "";
    document.getElementById("txtTitle").focus();
    return false;
}