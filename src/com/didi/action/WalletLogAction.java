package com.didi.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.po.EWalletLog;
import com.didi.po.EWalletLogExample;
import com.didi.ser.WalletLogService;
import com.didi.until.MyDateUtil;

@Controller
@RequestMapping(value = "/wallet")
public class WalletLogAction {

	@Resource
	WalletLogService walletLogService;

	/**
	 * 拉取指定时间内的信息
	 ***/
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, String startTime, String endTime, int type,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int perPage) {
		System.out.println("正常进入钱包函数");

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			    Calendar calendar = Calendar.getInstance();
			    calendar.setTime(MyDateUtil.parseDate(endTime));
				calendar.add(Calendar.DATE, 1);
		        Date timeEnd=calendar.getTime();
			
			EWalletLogExample example = new EWalletLogExample();
			EWalletLogExample.Criteria criteria = example.createCriteria();
			criteria.andLogDateGreaterThanOrEqualTo(MyDateUtil.parseDate(startTime));
			criteria.andLogDateLessThanOrEqualTo(timeEnd);
			criteria.andLogTypeEqualTo(type);
			criteria.andTransactionIdIsNotNull();

			List<EWalletLog> list = walletLogService.list(example, page, perPage);

			int count = walletLogService.countByExample(example);

			res.put("list", list);
			res.put("count", count);
			res.put("message", "成功了");
			res.put("status", 200);
	//		request.setAttribute("payShareList", list);
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;

		}

	}

	@RequestMapping(value = "exportExcel")
	public String exportExcel(HttpServletRequest request, String startTime, String endTime, int type) {
		System.out.println("正常进入登录函数");

		try {

			

		} catch (Exception e) {
			request.setAttribute("errMessage", e.getMessage());
			System.out.println(e.getMessage());
			return "/login.jsp";
		}

		return "/index.jsp";
	}

	@RequestMapping(value = "test")
	@ResponseBody
	public Map<String, Object> test() {
		System.out.println("正常进入ajax登录函数");

		Map<String, Object> res = new HashMap<String, Object>();

		res.put("message", "测试成功了");
		res.put("code", 200);
		return res;
	}

}
