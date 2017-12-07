
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="modal fade" id="addOrderModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">手动添加订单 </h4>
			</div>

			<div class="modal-body">
                     
				<form role="form-horizontal" action="user/addOrder" method="post"
			  
				 onsubmit="javascript:return confirm('此操作将会让用户免租金使用电池，请谨慎操作');"
				>
				 
				   <input type="hidden" id="userId"  name="userId" value=${user.id} >
				 					
					<div class="form-group">
						<label for="exampleInputEmail1">开始日期</label>
									 <input type="text"
											class="form-control datepicker" id="startDate" name="startDate"
											 data-date-format="yyyy-mm-dd">
					</div>
									
					<div class="form-group">
						<label for="exampleInputPassword1">结束日期</label> 
									 <input type="text"
											class="form-control datepicker" id="endDate" name="endDate"
											 data-date-format="yyyy-mm-dd">
					</div>
					
					<div class="form-group">
						<label for="exampleInputPassword1">设备类型</label> 
                                <select id="deviceName" name="deviceName" class="selectpicker show-tick form-control" multiple data-live-search="false">
                                        <option value="48V锂电池">48V锂电池</option>
                                        <option value="64V锂电池">64V锂电池</option>
                                        <option value="72V锂电池">72V锂电池</option>
                                        <option value="48V充电器">48V充电器</option>
                                        <option value="64V充电器">64V充电器</option>
                                        <option value="72V充电器">72V充电器</option>
                                        <option value="有线充电宝">有线充电宝</option>
                                        <option value="无线充电宝">无线充电宝</option>
                                   
                                </select>
                           
					</div>
					   <button type="submit" class="btn btn-info">Submit</button>          
				</form>
                 <div style="color:red"> <center> ${message}</center></div>

			</div>
			                   
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<!-- 	<button type="buttom" class="btn btn-primary">Save changes</button> -->
			
			
			</div>
		</div>
	</div>
</div>

