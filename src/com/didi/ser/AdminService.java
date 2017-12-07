package com.didi.ser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.DAdminMapper;
import com.didi.po.DAdmin;
import com.didi.po.DAdminExample;

@Service(value="AdminService")
public class AdminService {

	@Resource
	DAdminMapper adminMapper;
	
	public void login(DAdmin admin) throws Exception {
		// TODO Auto-generated method stub
		DAdminExample example=new DAdminExample();
		DAdminExample.Criteria criteria=example.createCriteria();
		
		criteria.andNameEqualTo(admin.getName());
		
		if(adminMapper.countByExample(example)==0){
			throw new Exception("用户名错误");
		}
		
		criteria.andPwdEqualTo(admin.getPwd());
		
		if(adminMapper.countByExample(example)==0){
			throw new Exception("密码错误");
		}	
		
		
	}

}
