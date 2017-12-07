package com.didi.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.didi.po.Stu;
import com.didi.ser.AdminService;
import com.didi.ser.StuService;

@Controller
@RequestMapping(value="/stu")
public class StuAction  {
	

	
   @RequestMapping(value="save")
   public String save(Stu stu){
	   System.out.println("正常进入测试函数");
       
	   return "/login.jsp";
   }
   
   
}
