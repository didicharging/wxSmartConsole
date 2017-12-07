package com.didi.ser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EChatMapper;
import com.didi.po.EChat;

@Service
public class ChatService {
  
	@Resource
	EChatMapper chatMapper;
	
	public int insert(EChat chat) {
		
		return chatMapper.updateByPrimaryKey(chat);
	}
	
}
