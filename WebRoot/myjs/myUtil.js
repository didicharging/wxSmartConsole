// 对Date的扩展，将 Date 转化为指定格式的String 
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ //author: meizz 
  var o = { 
    "M+" : this.getMonth()+1,                 //月份 
    "d+" : this.getDate(),                    //日 
    "h+" : this.getHours(),                   //小时 
    "m+" : this.getMinutes(),                 //分 
    "s+" : this.getSeconds(),                 //秒 
    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    "S"  : this.getMilliseconds()             //毫秒 
  }; 
  if(/(y+)/.test(fmt)) 
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o) 
    if(new RegExp("("+ k +")").test(fmt)) 
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
  return fmt; 
}

function myFormatDate(dateObj) {
	if((dateObj != null) && (dateObj != "")){
		return (new Date(dateObj)).Format("yyyy-MM-dd hh:mm:ss");
	}else{
		return "";
	}
}

function mySubString(oldvalue) {
	if(oldvalue != null){
		if(oldvalue.length > 20){
			return oldvalue.substring(0, 20) + "...";	
		}else{
			return oldvalue;
		}
	}
	return "";
}

function validate_required(value)
{
	if(value==null || value==""){
		return false
	}else {
		return true
	}
}
function validate_required_number(value)
{
	if(value==null || value==""){
		return false
	}else {
		 var reg = new RegExp("^[0-9]+$"); 
	     return reg.test(value);
	}
}
function validate_required_phone_number(value)
{
	if(value==null || value==""){
		return false
	}else {
		 //if(!(/^1(3|4|5|7|8)\d{9}$/.test(value))){ 
		 if(!(/^1\d{10}$/.test(value))){ 
		        return false; 
		 }else{
			 return true;
		 }
	}
}

function getQueryString(name) { 
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
	var r = window.location.search.substr(1).match(reg); 
	if (r != null) return unescape(r[2]); return null; 
}

