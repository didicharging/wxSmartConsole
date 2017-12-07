package com.didi.action;


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

import com.didi.po.EDevice;
import com.didi.po.EDeviceExample;
import com.didi.po.EScaneLog;
import com.didi.po.EScaneLogExample;
import com.didi.ser.DeviceService;
import com.didi.ser.ScaneLogService;
import com.didi.until.TextUtils;


@Controller
@RequestMapping(value = "/device")
public class DeviceAction {

	@Resource
	DeviceService deviceService;
	@Resource
	ScaneLogService scanerLogService;
	
	@RequestMapping(value = "list")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request, 
			@RequestParam(defaultValue = "")  String minNo, 
			@RequestParam(defaultValue = "")  String maxNo, 
			@RequestParam(defaultValue = "")  String name,
			@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int perPage) {


		Map<String, Object> res = new HashMap<String, Object>();

		try {
			
			 System.out.println("name: "+name);
             EDeviceExample example=new EDeviceExample();
             EDeviceExample.Criteria criteria=example.createCriteria();
             if(!TextUtils.isEmptyString(name)){
            	 criteria.andNameEqualTo(name);
             }
             if(!TextUtils.isEmptyString(minNo)){
            	 
            	 criteria.andDeviceNoGreaterThanOrEqualTo(minNo);
             }
             if(!TextUtils.isEmptyString(maxNo)){
            	 
            	 criteria.andDeviceNoLessThanOrEqualTo(maxNo);
             }
             
             example.setOrderByClause("device_no desc");
             
             
            List<EDevice> list=deviceService.list(example,page,perPage);
            
            int count=deviceService.countByExample(example);
            
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
	

	@RequestMapping(value = "getDeviceDetailById")
	public String getDetailById(String id,HttpServletRequest request ) {
		
		System.out.println("id: "+id);
           
		EDevice device = deviceService.getdeviceById(id);
	
		EScaneLogExample scaneLogExample=new EScaneLogExample();
		EScaneLogExample.Criteria scaneLogCriteria=scaneLogExample.createCriteria();
		scaneLogCriteria.andDeviceIdEqualTo(id);
		scaneLogExample.setOrderByClause("start_date");
		
		List<EScaneLog> list=scanerLogService.list(scaneLogExample,0,0);
		
		for (EScaneLog eScaneLog : list) {
			System.out.println("eee: "+eScaneLog);
		}
		
		System.out.println("count"+list.size());

		request.setAttribute("list", list);
		request.setAttribute("device", device);
		return "device/deviceDetail.jsp";
		
	}
	
	@RequestMapping(value = "endUse")
	@ResponseBody
	public Map<String, Object> endUse(HttpServletRequest request, String ScaneId) {

		Map<String, Object> res = new HashMap<String, Object>();
		
		System.out.println("成功进入解绑函数");
		
        //第一步找到日志
		try {

		EScaneLog scaneLog =scanerLogService.get(ScaneId);
		
		//第二步找到设备
		EDevice device =deviceService.getdeviceById(scaneLog.getDeviceId());
		
		//第三步结事日志
        scaneLog.setEndDate(new Date());
        scanerLogService.edit(scaneLog);
		
        //解绑设备
        device.setUserId(null);
        deviceService.edit(device);
        
        res.put("message","解绑成功了");
        res.put("status", 200);
        return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			res.put("message", e.getMessage());
			res.put("status", 210);
			return res;
		}
        
	}
   
	
	

	
}
