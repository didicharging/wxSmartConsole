
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- BEGIN ROW  -->
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading">
				<span class="label label-primary"> 嘀嘀币记录 </span> <span
					class="tools pull-right"> 
					
					<a href="#ddblog" data-toggle="collapse" class="fa fa-chevron-down"> 
					<a href="javascript:;"class="fa fa-times"> </a>
				</span>
			</header>
                       <div id="ddblog" class="panel-body collapse">
                           <div class="adv-table">
                              <table class="display table table-bordered table-striped" id="example3">
                                 <thead>
                                    <tr>
                                       <th>序号</th>
                                       <th class="hidden-phone">数量</th>
                                       <th class="hidden-phone">类型</th>
                                       <th>时间</th>
                                  
                           
                                    </tr>
                                 </thead>
                                                              
                                 <tbody>
                                 
                                 <c:forEach var="item" items="${ddbList}" varStatus="status">
                         
                                    <tr class="gradeX">
                                            <td>${status.index}</td>
           
                                       <td> ${item.amount}</td>
                                      
                                      <td> ${item.logType}</td>

                                       <td class="center hidden-phone">
								<fmt:formatDate
									value="${item.createTime }" pattern="yyyy-MM-dd HH:mm:ss" />
										</td>                           
						

                                    </tr>
                                
                                 </c:forEach>
                                 
                                 </tbody>
        
                              </table>
                           </div>
        
		</section>
	</div>
</div>
<!-- END ROW  -->