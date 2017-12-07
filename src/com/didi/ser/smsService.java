package com.didi.ser;

import java.util.ArrayList;
import java.util.Random;

import com.didi.until.sms.SmsSingleSender;
import com.didi.until.sms.SmsSingleSenderResult;

public class smsService {
  
  
    public static String sendValiCode(String phone) throws Exception{
    	
    	
    	  String text="0123456789";
     	    String valiCode="";
     	    Random random=new Random();
     	    for(int i=0;i<6;i++){
     		   char c=text.charAt(random.nextInt(text.length()));
     		    valiCode+=c;
   		 }
    	
    	int appid = 1400034856;
    	String appkey = "f9c860f93cb4139642bd3205d4c67f64";
    	int tmplId = 27716;    
    	ArrayList<String> params = new ArrayList<String>();
    	params.add(valiCode);
    	SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
    	SmsSingleSenderResult singleSenderResult;
    	singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, "", "", "");
    	
    	//发送失败	
    	if(singleSenderResult.result!=0){
    		throw new Exception("短信发送失败");
    	}
    	
    	return valiCode;
    	    	
    }
	
	
}
