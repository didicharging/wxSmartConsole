package com.didi.mapper;


import org.springframework.stereotype.Repository;

import com.didi.po.Stu;
@Repository
public interface StuMapper {

	public void stuSave(Stu stu);
	
}