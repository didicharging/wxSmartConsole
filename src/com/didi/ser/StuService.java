package com.didi.ser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.StuMapper;
import com.didi.po.Stu;

@Service(value="ser")
public class StuService {
   
	@Resource
	private StuMapper dao;
	

	public void save(Stu stu) {
		// TODO Auto-generated method stub
	  dao.stuSave(stu);	
	}
  	   	
}
