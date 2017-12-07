package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EUser;
import com.didi.po.EUserExample;

public interface EUserMapper {
    int countByExample(EUserExample example);

    int deleteByExample(EUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(EUser record);

    int insertSelective(EUser record);

    List<EUser> selectByExample(EUserExample example);

    EUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByExample(@Param("record") EUser record, @Param("example") EUserExample example);

    int updateByPrimaryKeySelective(EUser record);

    int updateByPrimaryKey(EUser record);
}