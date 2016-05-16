//
// 全局变量的定义
//
var MaxTitleLength      = 100   // 允许输入的最大标题长度
var MaxContentLength    = 1000  // 允许输入的最大内容长度

//
// 窗体加载时运行
//
window.onload = function()
{
    document.onkeydown = EnterToTab;
    if (trim(document.all("txtReceiver").value).length == 0)
    {
        document.all["txtReceiver"].focus();
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
// 检查页面数据的有效性
//
function CheckInput()
{
    var returnValue = true;
    // 检查接收人
    if (trim(document.getElementById("txtReceiver").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请输入接受人.";
        alert("提示信息:请输入接受人.");
        document.all["txtReceiver"].focus();
        return false;
    }
    // 检查标题
    if (trim(document.getElementById("txtTitle").value).length == 0)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:请输入标题.";
        alert("提示信息:请输入标题.");
        document.all["txtTitle"].focus();
        return false;
    }
    // 检查标题
    if (trim(document.getElementById("txtTitle").value).length > MaxTitleLength)
    {
        document.getElementById("lblPrompt").innerText = "提示信息:标题长度已超过" + MaxTitleLength + "个字符.";
        alert("提示信息:标题长度已超过" + MaxContentLength + "个字符.");
        document.all["txtTitle"].focus();
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
    return returnValue;
}

//
// 打开窗口
//
function Search()
{
    var result = openStdDlg("../Staff/StaffSearch.aspx", "", "500", "400");
    if(result != null)
    {
        document.getElementById("txtReceiver").value = result.UserName;
    }
}