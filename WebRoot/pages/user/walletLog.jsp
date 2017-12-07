
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- BEGIN ROW  -->
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<span class="label label-primary"> 钱包日志 </span> <span
					class="tools pull-right"> 
				
		
		<a href="#walletlog" data-toggle="collapse" class="fa fa-chevron-down"> 
		
					<a href="javascript:;"class="fa fa-times"> </a>
				</span>
			</header>
                        <div id="walletlog" class="panel-body collapse">
                           <div class="adv-table">
                              <table class="display table table-bordered table-striped" id="example">
                                 <thead>
                                    <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">金额</th>
                                       <th>类型</th>
                                       <th class="hidden-phone">时间</th>
                                       <th class="hidden-phone">单号</th>
                                    </tr>
                                 </thead>
                                 
                                 
                                 <tbody>
                                 
                                 <c:forEach var="item" items="${walletLogList}" varStatus="status">
                                 
                                    <tr class="gradeX">
                                       <td>${status.index}</td>
                                       <td class="hidden-phone">${item.money}元</td>
                                       <td class="center hidden-phone">
                                       <c:choose>

							<c:when test="${item.logType== '0'}">
								<span class="label label-primary">充值</span>

							</c:when>

							<c:when test="${item.logType== '2'}">
								<span class="label  label-warning ">退押金</span>
							</c:when>

							<c:when test="${item.logType== '3'}">
								<span class="label  label-Success ">提现</span>
							</c:when>

							<c:when test="${item.logType== '4'}">
								<span class="label  label-Success ">交押金</span>
							</c:when>

							<c:otherwise>
								<span class="label  label-default ">早期数据，无类型</span>
							</c:otherwise>

						</c:choose> </a></li>
                                       
                                       </td>
                                       <td><fmt:formatDate
									value="${item.logDate }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                       <td class="center hidden-phone">${item.id }</td>
                                    </tr>
                                 </c:forEach>
                                 
                                 </tbody>
                                 <tfoot>
                                    <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">金额</th>
                                       <th>类型</th>
                                       <th class="hidden-phone">时间</th>
                                       <th class="hidden-phone">单号</th>
                                    </tr>
                                 </tfoot>
                              </table>
                           </div>
        
		</section>
	</div>
</div>
<!-- END ROW  -->