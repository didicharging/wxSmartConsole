package com.didi.ser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EUserMapper;
import com.didi.mapper.EWalletMapper;
import com.didi.po.EUser;
import com.didi.po.EUserExample;

@Service
public class UserService {
	
	@Resource
	EUserMapper userMapper;
	
	@Resource
	EWalletMapper walletMapper;

	public List<EUser> list(EUserExample example, int page, int perPage) {
		
	if (page > 0 && perPage > 0) {
			example.setLimit(perPage);
			example.setOffset((page - 1) * perPage);
	 }
		
	  List<EUser> list=userMapper.selectByExample(example);
	  
	  System.out.println("listSize: "+list.size());
	  for (EUser eUser : list) {
		eUser.setWallet(walletMapper.selectByUserId(eUser.getId()));
	 }
	  
	  return list;

	}
	

	public int countByExample(EUserExample example) {
		// TODO Auto-generated method stub
		return userMapper.countByExample(example);
	}
	
	
	public EUser getUserById(String id){
		return userMapper.selectByPrimaryKey(id);
	}


	public int eidt(EUser user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(user);
			
	}
	
}
