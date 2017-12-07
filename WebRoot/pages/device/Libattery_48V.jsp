 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

  <!-- BEGIN ROW  -->
          <div class="row">
            <div class="col-lg-12">
              <section class="panel">
                <header class="panel-heading">
                  <span class="label label-primary">
                         设备管理
                  </span>
      <!--             <span class="tools pull-right">
                  
                    <a href="javascript:;" class="fa fa-chevron-down">
                    </a>
                    
                    <a href="#48lidevicelist" data-toggle="collapse" class="fa fa-chevron-down"> 
                    
                    <a href="javascript:;" class="fa fa-times">
                    </a>
                    
                  </span> -->
                </header>
                <div class="panel-body  " id="48lidevicelist">
                									
				   <form class="form-inline" role="form" id="searchForm" method="post">

									<div class="form-group">
									
										<label class="control-label">起始编号</label>
										 <input type="text" class="form-control " id="minNo_48V" name="minNo_48V">
                                     
									</div>
									
									<div class="form-group">
									
										<label class="control-label">结束编号</label> 
										<input type="text" class="form-control "
										 id="maxNo_48V" name="maxNo_48V"> 
										 
									</div>
									
												<div class="form-group">
						<label for="exampleInputPassword1">设备类型</label> 
                                <select id="deviceName" name="deviceName" class="selectpicker show-tick form-control"  data-live-search="false">
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
									
									
    							<button type="button" class="btn  btn-info" onclick="loadListData_48V(1);">开始查看</button>
								
								<!-- <button type="button" class="btn  btn-success" onclick="loadListData_48V(1);">开始查看</button>
								
								<button type="button" class="btn  btn-success" onclick="loadListData_48V(1);">开始查看</button>
	 -->
							</form> 		
									
									
									
									
                
                 <div class="space15">&nbsp</div>
                  <section id="unseen">
                    <table class="table table-bordered table-striped table-condensed">
                      <thead>
                        <tr>
                         
                          <th>
                                                                        设备号
                          </th>
                          
                          <th>
                                                                       当前用户
                          </th>
                          <th class="numeric">
                                                                      所有人
                          </th>
                          <th class="numeric">
                                                                     充电侠
                          </th>
                          <th class="numeric hidden-phone">
                                                                      名称
                          </th>
                          <th class="numeric hidden-phone">
                                                                      押金
                          </th>
                          <th class="numeric hidden-phone">
                                                                     租金
                          </th>
                          <th class="numeric hidden-phone">
                                                                     价格
                          </th>   
                          
                          <th class="numeric hidden-phone">
                                                                     流转次数
                          </th>
                          <th class="numeric">
                                                                      收押金数
                          </th>
                          
                          <th class="numeric">
                                                                       操作
                          </th>
                          
                        </tr>
                      </thead>
                      
                      <tbody  id="Content_48V">
                      
                      <center style="color:red">没有合适数据，更改查询条件重试</center>
                      
                   
                        
                    
                      </tbody>
                    </table>
                    
                    
                         <center>
							  <div id="list_page_info_48V"></div>
		 				</center>
                    
                    
                  </section>
                </div>
              </section>
            </div>
          </div>
		  <!-- END ROW  -->