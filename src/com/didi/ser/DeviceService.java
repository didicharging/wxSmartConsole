package com.didi.ser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EDeviceMapper;
import com.didi.po.EDevice;
import com.didi.po.EDeviceExample;
import com.didi.po.EWalletLog;

@Service
public class DeviceService {

	@Resource
	EDeviceMapper deviceMapper;
	
	public List<EDevice> list(EDeviceExample example, int page, int perPage) {
		// TODO Auto-generated method stub
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
		
	  List<EDevice> list=deviceMapper.selectByExample(example);
	  return list;

	}

	public int countByExample(EDeviceExample example) {
		// TODO Auto-generated method stub
		
		return deviceMapper.countByExample(example);
	}

	public EDevice getdeviceById(String id) {
		// TODO Auto-generated method stub
		return deviceMapper.selectByPrimaryKey(id);
	}

	public int edit(EDevice device) {
		// TODO Auto-generated method stub
		return deviceMapper.updateByPrimaryKey(device);
	}
  
	
}
