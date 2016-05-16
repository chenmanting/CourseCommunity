var initializationTime=(new Date()).getTime(); 
//
// 当前时间
//
function NowDate()
{
	var months=new Array(13);
	months[1]="1";
	months[2]="2";
	months[3]="3";
	months[4]="4";
	months[5]="5";
	months[6]="6";
	months[7]="7";
	months[8]="8";
	months[9]="9";
	months[10]="10";
	months[11]="11";
	months[12]="12";
	var time=new Date();
	var lmonth=months[time.getMonth() + 1];
	var date=time.getDate();
	var year=time.getYear(); 
	var hours=time.getHours();
 	var hours=time.getHours();
 	var minutes=time.getMinutes();
 	var seconds=time.getSeconds();
	if(hours < 10)
	{
		hours = "0" + hours
	}
 	var minutes=time.getMinutes();
	if(minutes < 10)
	{
		minutes = "0" + minutes
	}
 	var seconds=time.getSeconds();
	if(seconds < 10)
	{
		seconds = "0" + seconds
	}
	var week;
	if (time.getDay() == 5) week = "星期五"
	if (time.getDay() == 6) week = "星期六"
	if (time.getDay() == 0) week = "星期日"
	if (time.getDay() == 1) week = "星期一"
	if (time.getDay() == 2) week = "星期二"
	if (time.getDay() == 3) week = "星期三"
	if (time.getDay() == 4) week = "星期四"
	if (year < 2000)    
	year = year + 1900; 
	document.all.show.innerHTML = year + "年" + lmonth + "月" + date + "日 "+hours+":"+minutes+":"+seconds+" " + week;
	// 问候语言
	if(hours >= 4 && hours < 7)
	{
		document.all.time.innerHTML="凌晨好!";
	}
	if(hours >= 7 && hours < 11)
	{
		document.all.time.innerHTML="上午好!";
	}
	if(hours >= 11 && hours < 13)
	{
		document.all.time.innerHTML="中午好!";
	}
	if(hours >= 13 && hours < 17)
	{
		document.all.time.innerHTML="下午好!";
	}
	if(hours >= 17 && hours < 18)
	{
		document.all.time.innerHTML="傍晚好!";
	}
	if(hours >= 18 || hours < 4)
	{
		document.all.time.innerHTML="晚上好!";
	}
 	var timeID=setTimeout(NowDate,1000); 
}