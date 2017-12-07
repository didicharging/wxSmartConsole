package com.didi.ser;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.didi.mapper.EWalletMapper;
import com.didi.po.EWallet;

@Service
public class WalletService {

	@Resource
	EWalletMapper walletmapper;
	
	public EWallet getWalletByUserId(String userId){
	  return walletmapper.selectByUserId(userId);
	}


	public int edit(EWallet wallet) {
		// TODO Auto-generated method stub
		return walletmapper.updateByPrimaryKey(wallet);
	}
	
}
