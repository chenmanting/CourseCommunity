//代码开始
function F_viewSwf(width, height, wmode,ffwmode, url){
	document.write("<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' ");
	document.write("		codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' ");
	document.write("		width='"+width+"' height='"+height+"' align='middle'>");
	document.write("	<param name='allowScriptAccess' value='always' /> ");
	document.write("	<param name='movie'	value='"+url+"' /> ");
	document.write("	<param name='quality' value='high' /> ");
	document.write("	<param name='menu' value='false'> ");
	document.write("	<param name='wmode'	value='"+wmode+"'> ");
	document.write("	<embed src='"+url+"' quality='high' wmode='"+ffwmode+"' menu='false' width='"+width+"' height='"+height+"' align='middle' ");
	document.write("		allowScriptAccess='sameDomain' type='application/x-shockwave-flash' ");
	document.write("		pluginspage='http://www.macromedia.com/go/getflashplayer' />");
	document.write("</object>");
}

//代码结束

function image(url)
{
	var m=6; //随机显示图片的总数量
	var n=Math.floor(Math.random()*m+1) 
	switch(n)
	{
	case 1:
	document.write('<img src="'+url+'/banner.jpg">'); //第1个随机显示的图片地址
	break;
	case 2:
	document.write('<img src="'+url+'/banner1.jpg">'); //第2个随机显示的图片地址
	break;
	case 3:
	document.write('<img src="'+url+'/banner2.jpg">'); //第3个随机显示的图片地址
	break;
	case 4:
	document.write('<img src="'+url+'/banner3.jpg">'); //第4个随机显示的图片地址
	break;
	case 5:
	document.write('<img src="'+url+'/banner4.jpg">'); //第5个随机显示的图片地址
	break;
	case 6:
	document.write('<img src="'+url+'/banner5.jpg">'); //第6个随机显示的图片地址
	break;
	}
}