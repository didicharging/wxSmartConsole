package com.didi.ser;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EDdbMapper;
import com.didi.po.EDdb;
import com.didi.po.EDdbExample;


@Service
public class EDdbService {
 

	
	@Resource
	EDdbMapper ddbMapper;
	
	public List<EDdb> list(EDdbExample example,int page,int perPage){
	
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
	  List<EDdb> list=ddbMapper.selectByExample(example);
	  return list;
	} 	
}
