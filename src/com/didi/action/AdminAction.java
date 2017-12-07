package com.didi.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.didi.po.DAdmin;
import com.didi.ser.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminAction {

	@Resource
	private AdminService adminSer;

	@RequestMapping(value = "login")
	public String save(DAdmin admin, HttpServletRequest request) {
		System.out.println("正常进入登录函数");

		try {
			adminSer.login(admin);

		} catch (Exception e) {
			request.setAttribute("errMessage", e.getMessage());
			System.out.println(e.getMessage());
			return "/login.jsp";
		}
	
		return "/payShare.jsp";
	}
}
