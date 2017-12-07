package com.didi.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.didi.po.EChat;
import com.didi.po.EDdb;
import com.didi.po.EDdbExample;
import com.didi.po.EDevice;
import com.didi.po.EDeviceExample;
import com.didi.po.EOrders;
import com.didi.po.EOrdersExample;
import com.didi.po.EScaneLog;
import com.didi.po.EScaneLogExample;
import com.didi.po.EUser;
import com.didi.po.EUserExample;
import com.didi.po.EWallet;
import com.didi.po.EWalletExample;
import com.didi.po.EWalletLog;
import com.didi.po.EWalletLogExample;
import com.didi.ser.ChatService;
import com.didi.ser.EDdbService;
import com.didi.ser.OrderService;
import com.didi.ser.ScaneLogService;
import com.didi.ser.UserService;
import com.didi.ser.WalletLogService;
import com.didi.ser.WalletService;
import com.didi.ser.smsService;
import com.didi.until.MyDateUtil;
import com.didi.until.TextUtils;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

	@Resource
	UserService userService;

	@Resource
	WalletService wallerServie;

	@Resource
	WalletLogService walletLogService;

	@Resource
	ScaneLogService scaneLogService;

	@Resource
	OrderService orderService;

	@Resource
	EDdbService ddbService;

	@Resource
	ChatService chatService;

	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, @RequestParam(defaultValue = "") String startTime,
			@RequestParam(defaultValue = "") String endTime, @RequestParam(defaultValue = "") String phone,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String nickName,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int perPage) {

		// 第一步参数回显
		System.out.println("name: " + name);

		Map<String, Object> res = new HashMap<String, Object>();

		try {

			EUserExample example = new EUserExample();
			EUserExample.Criteria criteria = example.createCriteria();
			if (!startTime.equals("")) {
				criteria.andCreateTimeGreaterThanOrEqualTo(MyDateUtil.parseDate(startTime));
			}

			if (!endTime.equals("")) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(MyDateUtil.parseDate(endTime));
				calendar.add(Calendar.DATE, 1);
				Date timeEnd = calendar.getTime();
				criteria.andCreateTimeLessThanOrEqualTo(timeEnd);
			}
			if (!phone.equals("")) {
				criteria.andPhoneEqualTo(phone);
			}
			if (!name.equals("")) {
				criteria.andNameEqualTo(name);
			}
			if (!nickName.equals("")) {
				criteria.andNickNameLike("%" + nickName + "%");
			}

			List<EUser> list = userService.list(example, page, perPage);
			int count = userService.countByExample(example);

			System.out.println("count: " + count);

			res.put("list", list);
			res.put("count", count);
			res.put("message", "成功了");
			res.put("status", 200);

			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;

		}

	}

	@RequestMapping(value = "getUserDetail")
	public String getUserDetail(String id, HttpServletRequest request) {

		// 第一步查找用用户基本信息
		EUser user = userService.getUserById(id);
		request.setAttribute("user", user);
		// 第二步 查找账户
		EWallet wallet = wallerServie.getWalletByUserId(id);
		request.setAttribute("wallet", wallet);

		// 第三步 查找钱包日志
		EWalletLogExample walletLogExample = new EWalletLogExample();
		EWalletLogExample.Criteria criteria = walletLogExample.createCriteria();
		criteria.andUserIdEqualTo(id);
		walletLogExample.setOrderByClause("log_date desc");

		List<EWalletLog> walletLogList = walletLogService.list(walletLogExample, 0, 0);
		request.setAttribute("walletLogList", walletLogList);

		// 第四步 查找扫码记录
		EScaneLogExample scaneLogExample = new EScaneLogExample();
		EScaneLogExample.Criteria scaneLogCriteria = scaneLogExample.createCriteria();
		scaneLogCriteria.andUserIdEqualTo(id);
		scaneLogExample.setOrderByClause("start_date desc");

		List<EScaneLog> scaneLogList = scaneLogService.list(scaneLogExample, 0, 0);
		request.setAttribute("scaneLogList", scaneLogList);

		// 第五步 查找订单
		EOrdersExample orderExample = new EOrdersExample();
		EOrdersExample.Criteria orderCriteria = orderExample.createCriteria();
		orderCriteria.andUserIdEqualTo(id);
		orderExample.setOrderByClause("start_date desc");

		List<EOrders> orderList = orderService.list(orderExample, 0, 0);

		request.setAttribute("orderList", orderList);

		// 第六步 查找嘀嘀币记录
		EDdbExample ddbExample = new EDdbExample();
		EDdbExample.Criteria ddbCriteria = ddbExample.createCriteria();
		ddbCriteria.andUserIdEqualTo(id);
		ddbExample.setOrderByClause("create_time desc");

		List<EDdb> ddbList = ddbService.list(ddbExample, 0, 0);
		request.setAttribute("ddbList", ddbList);

		return "user/userDetail.jsp";
	}

	@RequestMapping(value = "setUserState")
	@ResponseBody
	public Map<String, Object> setUserState(String id, int state, HttpServletRequest request) {
		Map<String, Object> res = new HashMap<String, Object>();

		try {
			if (state == 1) {
				EUser user = userService.getUserById(id);
				user.setState(state);
				userService.eidt(user);
			}

			if (state == 0) {
				EChat chat = new EChat();
				chat.setChatDate(new Date());
				chat.setContent("请重新上传身份证后再试");
				chat.setFromUser("admin");
				chat.setToUser(id);
				chat.setIsDelete(0);
				chat.setIsRead(0);
				chatService.insert(chat);
			}

			res.put("message", "变更成功了");
			res.put("status", 200);

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;

		}

	}

	@RequestMapping(value = "setUserWallet")
	@ResponseBody
	public Map<String, Object> setUserWallet(String userId, Integer amount, BigDecimal shareAmount, Integer role,
			String valiCode, HttpServletRequest request) {

		Map<String, Object> res = new HashMap<String, Object>();

		String vali = (String) request.getSession().getAttribute("valiCode");
//		if (!vali.equals(valiCode)) {
//			request.setAttribute("errMessage", "验证码错误");
//			res.put("status", 210);
//			res.put("message", "验证码错误");
//			return res;
//		}

		try {
			EWallet wallet = wallerServie.getWalletByUserId(userId);
			wallet.setAmount(amount);
			wallet.setShareAmount(shareAmount);
			if (null != role) {
				wallet.setRole(role);
			}
			wallerServie.edit(wallet);
			res.put("message", "更改成功");
			res.put("status", 200);
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;
		}

	}

	@RequestMapping(value = "sendValiCode")
	@ResponseBody
	public Map<String, Object> sendValiCode(HttpServletRequest request) {

		Map<String, Object> res = new HashMap<String, Object>();
		try {

			System.out.println("进入发送验证码函数");

			String valiCode = smsService.sendValiCode("18811695087");

			System.out.println("valiCode: " + valiCode);

			request.getSession().setAttribute("valiCode", valiCode);
			res.put("message", "变更成功了");
			res.put("status", 200);
			return res;

		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;
		}

	}

	@RequestMapping(value = "addOrder")
	public String addOrder(String userId, String startDate, String endDate, String deviceName,
			HttpServletRequest request) {

		System.out.println("userId: "+userId);
		
		if(TextUtils.isEmptyString(userId) ||TextUtils.isEmptyString(startDate)||
				TextUtils.isEmptyString(endDate)||TextUtils.isEmptyString(deviceName)){
			return "redirect:/user/getUserDetail?id=" + userId;
		}
		
		try {
			EOrders order = new EOrders();
			order.setCreateTime(new Date());
			order.setDeviceId("");
			order.setDeviceName(deviceName);
			order.setStartDate(MyDateUtil.parseDate(startDate));
			order.setEndDate(MyDateUtil.parseDate(endDate));
			order.setId(TextUtils.getIdByUUID());
			order.setUserId(userId);
			orderService.insert(order);
			request.setAttribute("message", "插入成功了");

		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "插入失败了");
		}

		return "redirect:/user/getUserDetail?id=" + userId;
	
	}

}
