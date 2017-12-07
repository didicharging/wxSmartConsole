
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">用户信息设置</h4>
			</div>

			<div class="modal-body">
                     
				<form role="form-horizontal">
				 
				   <input type="hidden" id="userId" value=${user.id} >
				 					
					<div class="form-group">
						<label for="exampleInputEmail1">余额（嘀嘀币）</label>
						 <input
							type="text" class="form-control"  id=amount value=${wallet.amount} 
							>
					</div>
									
					<div class="form-group">
						<label for="exampleInputPassword1">押金</label> <input
							type="text" class="form-control" id="shareAmount" value=${wallet.shareAmount}>
					</div>

   
                   <div class="form-group">
						<label for="exampleInputPassword1">类型</label> 
                                <select name="userType" id="userType" class=" form-control"  >
                                        <option value=1 <c:if test="${1 eq wallet.role}">selected</c:if>>普通用户</option>
                                        <option value=98 <c:if test="${98 eq wallet.role}">selected</c:if>>集团用户</option>
                                        <option value=99 <c:if test="${99 eq  wallet.role}">selected</c:if> >充电侠</option>
                                </select>
                                                                                
					</div> 
                    
                    
                    <div class="form-group">
						<label for="exampleInputPassword1">验证码</label> 
						<input type="text" class="form-control"  id="valiCode" >
					</div>
					
					
                    
                    
                           
				</form>


			</div>
			                   
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="setUserWallet();">Save changes</button>
			</div>
		</div>
	</div>
</div>
