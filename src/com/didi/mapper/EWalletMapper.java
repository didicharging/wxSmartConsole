package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EWallet;
import com.didi.po.EWalletExample;

public interface EWalletMapper {
    int countByExample(EWalletExample example);

    int deleteByExample(EWalletExample example);

    int deleteByPrimaryKey(String id);

    int insert(EWallet record);

    int insertSelective(EWallet record);

    List<EWallet> selectByExample(EWalletExample example);

    EWallet selectByPrimaryKey(String id);
    
    EWallet selectByUserId(String userId);
    
    int updateByExampleSelective(@Param("record") EWallet record, @Param("example") EWalletExample example);

    int updateByExample(@Param("record") EWallet record, @Param("example") EWalletExample example);

    int updateByPrimaryKeySelective(EWallet record);

    int updateByPrimaryKey(EWallet record);
        
}