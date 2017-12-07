
var pageData = {
	page : 1,
	perPage : 10,
	totalPage : 1

};

$(document).ready(function() {


	$('.datepicker').datepicker();
    
	loadListData(1);
	
});


function loadListData(page) {
	var start_data = $("#startTime").val();
	var end_data = $("#endTime").val();
	var nick_name = $("#nickName").val();
	var name = $("#name").val();
	var phone = $("#phone").val();
	
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
		url : "/ssm/user/list",
		type : "post",
		data : {
			startTime : start_data,
			endTime : end_data,
			nickName :nick_name,
			name :name,
			phone :phone,
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
					
					$("#userContent").html("在选定时间没有交易发生");
				}
				
				if (list && result.count != 0) {

			
					isOK = true;
					for (var i in list) {

						var item = list[i];
						var itemStr = "";
                        var state="";
						
						if(item.state=0){
						
							state="<span class='label label-warning'>未认证</span>"
						} else{
							
							state="<span class='label label-success'>已认证</span>"
						}
						
						var amount="";
						var sharaAmount="";
						if(item.wallet!=null){
							amount=item.wallet.amount;
							sharaAmount=item.wallet.shareAmount;
						}
						
					 
						itemStr += "<tr>"
							+ "<td >" + ((pageData.page-1)*pageData.perPage+(i*1+1)) + "</td>"
							+ "<td class='hidden-phone'> <img width='80px' height='80px'src=" + item.profileImage + "></td>"
							+ "<td class='hidden-phone'>" + item.name + "</td>"
							+ "<td class='hidden-phone'>" + item.nickName + "</td>"
				        	+ "<td class='hidden-phone'>" + amount + "</td>"
							+ "<td class='hidden-phone'>" + sharaAmount + "</td>"
							+ "<td class='hidden-phone'>" + new Date(item.createTime).Format("yyyy-MM-dd hh:mm:ss") + "</td>"
						
							+ "<td class='hidden-phone'>" + state + "</td>"
						
						    + "<td class='hidden-phone'>"
		                    + "<a type='button' class='btn btn-primary' href=user/getUserDetail?id="+item.id+">查看</a>"  
		                    + "</td>" 
										
						    +"</tr>"
						
						listContent += itemStr;
					}
	
					$("#userContent").html(listContent);

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

function endUse(ScaneId){
	
	 var r=confirm("手动结束，仅用于特殊情况，不会给客户计费，")
	  if (r==false)
	    {
		  return ;
	
	    }


	$.ajax({
		url : "/ssm/device/endUse",
		type : "get",
		data : {
			ScaneId : ScaneId

		},
		async : true,
		success : function(result) {

			if (result.status == 210) {
				alert("查询出错了，原因：" + result.message);
			}

			if (result.status == 200) {
                alert("已成功解绑设备 ");
			}
		
		}
		})
	
}






