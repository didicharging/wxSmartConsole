package com.didi.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EWalletLog;
import com.didi.po.EWalletLogExample;

public interface EWalletLogMapper {
    int countByExample(EWalletLogExample example);

    int deleteByExample(EWalletLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(EWalletLog record);

    int insertSelective(EWalletLog record);

    List<EWalletLog> selectByExample(EWalletLogExample example);

    EWalletLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EWalletLog record, @Param("example") EWalletLogExample example);

    int updateByExample(@Param("record") EWalletLog record, @Param("example") EWalletLogExample example);

    int updateByPrimaryKeySelective(EWalletLog record);

    int updateByPrimaryKey(EWalletLog record);
    
    BigDecimal getShareMoneyByDeviceId(String id);
        
}