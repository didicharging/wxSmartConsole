
$(document).ready(function() {


	
	$('.datepicker').datepicker();


	
	 $('#example').dataTable( {
         "aaSorting": [[ 4, "desc" ]],
        "aLengthMenu":[5,10, 25, 50, 100],
                 "iDisplayLength":5
     } );
     
     $('#example1').dataTable( {
         "aaSorting": [[ 4, "desc" ]],
      "aLengthMenu":[5,10, 25, 50, 100],
               "iDisplayLength":5
     } );
     
     
     $('#example2').dataTable( {
         "aaSorting": [[ 4, "desc" ]],
         "aLengthMenu":[5,10, 25, 50, 100],
                  "iDisplayLength":5
     } );
     
     $('#example3').dataTable( {
         "aaSorting": [[ 4, "desc" ]],
         "aLengthMenu":[5,10, 25, 50, 100],
         "iDisplayLength":5
        
     } );
	
	
	
});



function endUse(ScaneId){
	
	 var r=confirm("手动结束，仅用于特殊情况，不会给客户计费，")
	  if (r==true)
	    {
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
		  
	    }else{
	    	return;
	    }

}

function canrecive(userId){
//	 var r=confirm("请仔细核对用户身份信息，核实完成用户可以租用锂电池");
//	 if (r==true){
		 $.ajax({
			  url : "/ssm/user/setUserState",
			  type : "get",
			  data : {
				  userId : userId,
		          state:1
			  },
			  async : true,
			  success : function(result) {
				  
				  if (result.status == 210) {
					  alert("查询出错了，原因：" + result.message);
				  }
				  
				  if (result.status == 200) {
					  alert("已成功验证用户 ");
				  }
				  
			  }
		  })
		 
//	 }
//	 else{
//		 return ;
//	 }
	
}

function notcanrecive (userId){
//	 var r=confirm("请仔细核对用户身份信息，核实完成用户可以租用锂电池");
//	 if (r==true){
		 $.ajax({
			  url : "/ssm/user/setUserState",
			  type : "get",
			  data : {
				  userId : userId,
		          state:0
			  },
			  async : true,
			  success : function(result) {
				  
				  if (result.status == 210) {
					  alert("查询出错了，原因：" + result.message);
				  }
				  
				  if (result.status == 200) {
					  alert("已成功拒绝用户");
				  }
				  
			  }
		  })
//		 
//	 }
//	 else{
//		 return ;
//	 }
}

function getValiCode(){

	// $('#myModal').modal('show')
	
//	 var r=confirm("用户敏感信息，需手机验证码");
//	 if (r==true){
//		 
		  $('#myModal').modal('show')
		 
//		 $.ajax({
//			  url : "/ssm/user/sendValiCode",
//			 
//			  type : "get",
//		
//			  async : true,
//			  success : function(result) {
//				  
//				  if (result.status == 210) {
//					  alert("查询出错了，原因：" + result.message);
//				  }
//				  
//				  if (result.status == 200) {
//					 // alert("已成功拒绝用户");
//					  $('#myModal').modal('show')
//					 
//				  }
//				  
//			  }
//		  })
		 
//	 }
}



function setUserWallet(){
	
	var userId = $("#userId").val();
	var amount = $("#amount").val();
	var shareAmount = $("#shareAmount").val();
	var valiCode = $("#valiCode").val();
	var role =$("#userType").val();
	
    
	
			

	
	 $.ajax({
		  url : "/ssm/user/setUserWallet",
		 
		  type : "get",
		  
		  data : {
			  userId : userId,
			  amount : amount,
			  shareAmount :shareAmount,
			  valiCode :valiCode,
			  role :role
				
			},
	
		  async : true,
		  success : function(result) {
			  
			  if (result.status == 210) {
				  alert("修改出错了，原因：" + result.message);
			  }
			  
			  if (result.status == 200) {
				 // alert("已成功拒绝用户");
				  alert("修改成功了");
				  $('#myModal').modal('toggle');
			  }
			  
		  }
	  })
	
	
}


