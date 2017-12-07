package com.didi.ser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EWalletLogMapper;
import com.didi.po.EWalletLog;
import com.didi.po.EWalletLogExample;

@Service
public class WalletLogService {
 
	@Resource
	EWalletLogMapper walletLogMapper;
	
	public List<EWalletLog> list(EWalletLogExample example, int page, int perPage) {
		
		if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
		}
	  List<EWalletLog> list=walletLogMapper.selectByExample(example);
	  return list;
	}
	
	public int countByExample(EWalletLogExample example){
		return walletLogMapper.countByExample(example);
		
	}
	
	
	
	
	
	
	
}
