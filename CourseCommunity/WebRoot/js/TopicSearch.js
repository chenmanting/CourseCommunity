document.onkeydown = function EnterToTab() {
    if (event.keyCode == 13 && event.srcElement.type!='button' && event.srcElement.type!='submit' && event.srcElement.type!='file' && event.srcElement.type!='reset' && event.srcElement.type!='textarea' && event.srcElement.type!='') {
        event.keyCode = 9
    }
    document.all["txtSearch"].focus();
    document.all["txtSearch"].select();
}

//
// 查询时的检查
//
function CheckSearchContent()
{
    if (document.getElementById("txtSearch").value.length == 0)
    {
        alert("提示信息:请输入要查询的内容.");
        document.all["txtSearch"].focus();
        return true;
    }
    // 这里是为了查询内容不输入时页面还可以进行查询用
    return true;
}