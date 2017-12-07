
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- BEGIN ROW  -->
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<span class="label label-primary"> 扫码日志 </span> <span
					class="tools pull-right"> 
					<!-- <a href="javascript:;" class="fa fa-chevron-down"> </a> -->
					
					<a href="#devicelog" data-toggle="collapse" class="fa fa-chevron-down"> 
					 <a href="javascript:;"class="fa fa-times"> </a>
				</span>
			</header>
                        <div id="#devicelog" class="panel-body collapse">
                           <div class="adv-table">
                              <table class="display table table-bordered table-striped" id="example1">
                                 <thead>
                                    <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">设备号</th>
                                       <th class="hidden-phone">设备名称</th>
                                       <th>开始时间</th>
                                       <th class="hidden-phone">结束时间</th>
                                       <th class="hidden-phone">操作</th>
                                    </tr>
                                 </thead>
                                                              
                                 <tbody>
                                 
                                 <c:forEach var="item" items="${scaneLogList}" varStatus="status">
                                  
                                    <tr class="gradeX">
                                       <td>${status.index}</td>
                                       <td class="hidden-phone">${item.device.deviceNo}	</td>
                                       <td class="center hidden-phone">${item.device.name} </td>
                                       <td><fmt:formatDate
									value="${item.startDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                       <td class="center hidden-phone">
								<fmt:formatDate
									value="${item.endDate }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									<td>
								
		                             <c:if test="${item.endDate ==null}">
									  <button type="button" class="btn btn-success"  
									   onclick="endUse('${item.id}')"
									   >
									  手动结束</button>
									  
									</c:if>
									  
									</td>

                                    </tr>
                                 </c:forEach>
                                 
                                 </tbody>
                                 <tfoot>
                                     <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">设备号</th>
                                       <th class="hidden-phone">设备名称</th>
                                       <th>开始时间</th>
                                       <th class="hidden-phone">结束时间</th>
                                    </tr>
                                 </tfoot>
                              </table>
                           </div>
        
		</section>
	</div>
</div>
<!-- END ROW  -->