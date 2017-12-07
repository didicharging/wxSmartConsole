
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- BEGIN ROW  -->
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<span class="label label-primary"> 订单表 </span> 
				
				<span
					class="tools pull-right"> 
					
					<a href="#order" data-toggle="collapse" class="fa fa-chevron-down"> 
					
					<a href="javascript:;" class="fa fa-times"> </a>
				</span>
			</header>
                       <div id="order" class="panel-body collapse" >
                 
    
                           <div class="adv-table">
                           
                              <table class="display table table-bordered table-striped" id="example2">
                                 <thead>
                                    <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">开始时间</th>
                                       <th class="hidden-phone">结束时间</th>
                                       <th>设备类型</th>
                                       <th>单号</th>
                           
                                    </tr>
                                 </thead>
                                                              
                                 <tbody>
                                 
                                 <c:forEach var="item" items="${orderList}" varStatus="status">
                                                          
                                    <tr class="gradeX">
                                            <td>${status.index}</td>
           
                                       <td><fmt:formatDate
									value="${item.startDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                      
                                       <td class="center hidden-phone">
								<fmt:formatDate
									value="${item.endDate }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>                           
									  <td>${item.deviceName}</td> 
									 <td>${item.id}</td>

                                    </tr>
                                
                                 </c:forEach>
                                 
                                 </tbody>
                                 <tfoot>
                                     <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">开始时间</th>
                                       <th class="hidden-phone">结束时间</th>
                                       <th>设备类型</th>
                                       <th>单号</th>
                             
                                    </tr>
                                 </tfoot>
                              </table>
                           </div>
        
		</section>
	</div>
</div>





<!-- END ROW  -->