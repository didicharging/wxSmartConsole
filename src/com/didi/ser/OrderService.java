package com.didi.ser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EDeviceMapper;
import com.didi.mapper.EOrdersMapper;
import com.didi.po.EDevice;
import com.didi.po.EOrders;
import com.didi.po.EOrdersExample;

@Service
public class OrderService {
	
	@Resource
	EOrdersMapper orderMapper;
	
	public List<EOrders> list(EOrdersExample example,int page,int perPage){
	
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
	  List<EOrders> list=orderMapper.selectByExample(example);
	  return list;
	}

	public int insert(EOrders order) {
		// TODO Auto-generated method stub
	 return orderMapper.insert(order);
	} 	
	
}
