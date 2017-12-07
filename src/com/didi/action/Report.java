package com.didi.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.ser.StatisticsService;
import com.didi.until.MyDateUtil;

@Controller
@RequestMapping("/report")
public class Report {
	
	@Resource
	StatisticsService service;
	
	@RequestMapping(method={RequestMethod.GET}, value="list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,
			HttpServletResponse response,
			String startTime,
			String endTime
			) throws Exception{

//		startTime
//		endTime
		
		System.out.println("成功进入函数");
		
		Map<String, Object> res = new HashMap<String, Object>();
		
		List<Map<String, Object>> list=service.list(MyDateUtil.parseDate(startTime),
				MyDateUtil.parseDate(endTime));
		res.put("list", list);
		res.put("status", 200);
		res.put("message", "查找成功");
		
		return res;
		
	}
	
	@RequestMapping(method={RequestMethod.POST}, value="exportExcel")
	public void exportExcel(HttpServletRequest request,
			HttpServletResponse response,
			String startTime,
			String endTime
			) throws Exception{
				
		Object obj = request.getSession().getAttribute("admin");
		
	/*	if(null==obj){
			response.setCharacterEncoding("UTF-8");  
			response.setHeader("Content-type", "text/html;charset=UTF-8");  
			response.setHeader("refresh", "3;url='/static/login.html'");  
			response.getWriter().write(  
					"未登录，将在3秒后跳转到首页");			
		}else{*/
			HSSFWorkbook wb=service.exportEexel(MyDateUtil.parseDate(startTime),
					MyDateUtil.parseDate(endTime));
			
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="+ 
					new String((startTime+"__TO__"+endTime+"reports" + ".xls").getBytes(),
							"UTF-8"));
	
/*			response.setHeader("Content-Disposition", "attachment;filename="+ 
					new String((startTime+".xls").getBytes(),
							"UTF-8"));*/
			
			wb.write(response.getOutputStream());
			
//		}
		
	}

}
