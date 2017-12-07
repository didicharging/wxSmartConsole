package com.didi.ser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EScaneLogMapper;
import com.didi.po.EScaneLog;
import com.didi.po.EScaneLogExample;

@Service
public class ScaneLogService {

	@Resource
	EScaneLogMapper scaneLogMapper;
	
	public List<EScaneLog> list(EScaneLogExample example, int page, int perPage) {
		// TODO Auto-generated method stub
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
	  List<EScaneLog> list=scaneLogMapper.selectByExample(example);
	  return list;

	}

	public EScaneLog get(String scaneId) {
		// TODO Auto-generated method stub
		return scaneLogMapper.selectByPrimaryKey(scaneId);
	}

	public int edit(EScaneLog scaneLog) {
		// TODO Auto-generated method stub
		return scaneLogMapper.updateByPrimaryKey(scaneLog);
	}
	
	
	
	
	
	
}
