package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EShare;
import com.didi.po.EShareExample;

public interface EShareMapper {
    int countByExample(EShareExample example);

    int deleteByExample(EShareExample example);

    int deleteByPrimaryKey(String id);

    int insert(EShare record);

    int insertSelective(EShare record);

    List<EShare> selectByExample(EShareExample example);

    EShare selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EShare record, @Param("example") EShareExample example);

    int updateByExample(@Param("record") EShare record, @Param("example") EShareExample example);

    int updateByPrimaryKeySelective(EShare record);

    int updateByPrimaryKey(EShare record);
}