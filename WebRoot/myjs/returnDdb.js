
var pageData = {
	page : 1,
	perPage : 10,
	totalPage : 1,
	wallet_log_type : 3,
};

$(document).ready(function() {


	$('.datepicker').datepicker();
	$('#startTime').val(new Date().Format("yyyy-MM-dd"));
	$('#endTime').val(new Date().Format("yyyy-MM-dd"));
	//loadListData(1);
	
});

function findDay(){
	$('#startTime').val(new Date().Format("yyyy-MM-dd"));
	$('#endTime').val(new Date().Format("yyyy-MM-dd"));
	loadListData(1);
}

function findWeek(){
	$('#endTime').val(new Date().Format("yyyy-MM-dd"));
	var d=new Date();	
	d.setDate(d.getDate()-7)
	$('#startTime').val(d.Format("yyyy-MM-dd"));
	loadListData(1);
} 

function findMonth(){
	$('#endTime').val(new Date().Format("yyyy-MM-dd"));
	var d=new Date();	
	d.setMonth(d.getMonth()-1);
	$('#startTime').val(d.Format("yyyy-MM-dd"));
	loadListData(1);
}


function loadListData(page) {
	var start_data = $("#startTime").val();
	var end_data = $("#endTime").val();
	
	var start = new Date(start_data.replace("-", "/").replace("-", "/"));
	var end = new Date(end_data.replace("-", "/").replace("-", "/"));

	if (end < start) {
		alert('结束日期不能小于开始日期！');
		return false;
	}

	var myDate = new Date();
		
	if (end > myDate) {
		alert('结束日期不能超过今天');
		return false;
	}
	

	$.ajax({
		url : "/ssm/wallet/list",
		type : "get",
		data : {
			startTime : start_data,
			endTime : end_data,
			type : pageData.wallet_log_type,
			page : page,
			perPage : pageData.perPage
		},
		async : true,
		success : function(result) {
			
		
			if (result.status == 210) {
				alert("查询出错了，原因：" + result.message);
			}

			if (result.status == 200) {

		
				var list = result.list;
				var listContent = "";

				if(result.count == 0){
					alert("没有找到合适的结果");
					
					$("#payShareContent").html("在选定时间没有交易发生");
				}
				
				if (list && result.count != 0) {

			
					isOK = true;
					for (var i in list) {

						var item = list[i];
						var itemStr = "";

						if(item.device!=null && item.device.deviceNo!=null){
							deviceNo=item.device.deviceNo;
						} else{
							deviceNo="";
						}
						
						

						itemStr += "<tr>"
							+ "<td >" + ((pageData.page-1)*pageData.perPage+(i*1+1)) + "</td>"
							+ "<td class='hidden-phone'>" + item.user.nickName + "</td>"
						
							+ "<td class='hidden-phone'>" + item.money + "</td>"
							+ "<td class='hidden-phone'>" + new Date(item.logDate).Format("yyyy-MM-dd hh:mm:ss") + "</td>"
							+ "<td class='hidden-phone'>" + item.id + "</td>";

						listContent += itemStr;
					}
	
					$("#payShareContent").html(listContent);

					/*开始分页*/

					pageData.totalPage = Math.ceil(result.count / pageData.perPage);

					$("#list_page_info").pagination({
						currentPage : pageData.page,
						totalPage : pageData.totalPage,
						isShow : true,
						count : pageData.totalPage > 5 ? 5 : pageData.totalPage,
						homePageText : "首页",
						endPageText : "尾页",
						prevPageText : "上一页",
						nextPageText : "下一页",
						callback : function(current) {
							loadListData(current);
							pageData.page = current;
						}
					});

				}


			} else {
				console.log("failed");
			}

		}
	}

	)

}



