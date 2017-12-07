package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EScaneLog;
import com.didi.po.EScaneLogExample;

public interface EScaneLogMapper {
	
    int countByExample(EScaneLogExample example);

    int deleteByExample(EScaneLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(EScaneLog record);

    int insertSelective(EScaneLog record);

    List<EScaneLog> selectByExample(EScaneLogExample example);

    EScaneLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EScaneLog record, @Param("example") EScaneLogExample example);

    int updateByExample(@Param("record") EScaneLog record, @Param("example") EScaneLogExample example);

    int updateByPrimaryKeySelective(EScaneLog record);

    int updateByPrimaryKey(EScaneLog record);
}