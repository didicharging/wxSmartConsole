
$(document).ready(function() {
    

	$("#minNo_48V").val("didi7010000001");
	$("#maxNo_48V").val("didi7010000300");
	
	loadListData_48V(1);
	
});

var pageData_48V = {
		page : 1,
		perPage : 10,
		totalPage : 1,
		
};

function loadListData_48V(page) {

	var minNo = $('#minNo_48V').val();
	var maxNo = $('#maxNo_48V').val();
	var name=$('#deviceName').val();
	$.ajax({
		url : "/ssm/device/list",
		type : "post",
		data : {
			minNo:minNo,
			maxNo:maxNo,
			name:name,
			page : page,
			perPage : pageData_48V.perPage
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
								
					listContent="在选定时间没有交易发生";					
	
				}
				
				if (list && result.count != 0) {
			
					isOK = true;
					for (var i in list) {

						var item = list[i];
						var itemStr = "";

						if(item.user_d!=null && item.user_d.nickName!=null){
							user_nickName=item.user_d.nickName;
						} else{
							user_nickName="";
						}
						
						itemStr += "<tr>"
							+ "<td >" + item.deviceNo + "</td>"
							+ "<td class='hidden-phone'>" + user_nickName + "</td>"
							+ "<td class='hidden-phone'>" + item.owner_d.nickName + "</td>"
							+ "<td class='hidden-phone'>" + item.manager_d.nickName + "</td>"
																			
							+ "<td class='hidden-phone'>" + item.name + "</td>"
							
							+ "<td class='hidden-phone'>" + item.shareMoney + "</td>"
							+ "<td class='hidden-phone'>" + item.rental + "</td>"
							+ "<td class='hidden-phone'>" + item.price + "</td>"
							
							+ "<td class='hidden-phone'>" + item. scaneCode + "</td>" //扫码
							+ "<td class='hidden-phone'>" + item.money + "</td>"  //收押金数

						    + "<td class='hidden-phone'>"
		                    + "<a type='button' class='btn btn-primary' href=device/getDeviceDetailById?id="+item.id+">查看</a>"  
		                    + "</td>"  
		                    + "</tr>";
						
						listContent += itemStr;
					}
	

					/*开始分页*/

					pageData_48V.totalPage = Math.ceil(result.count / pageData_48V.perPage);

					$("#list_page_info_48V").pagination({
						currentPage : pageData_48V.page,
						totalPage : pageData_48V.totalPage,
						isShow : true,
						count : pageData_48V.totalPage > 5 ? 5 : pageData_48V.totalPage,
						homePageText : "首页",
						endPageText : "尾页",
						prevPageText : "上一页",
						nextPageText : "下一页",
						callback : function(current) {
							loadListData_48V(current);
							pageData_48V.page = current;
						}
					});
					
										

				}
				
				$("#Content_48V").html(listContent);


			} else {
				console.log("failed");
			}

		}
	}

	)

}





