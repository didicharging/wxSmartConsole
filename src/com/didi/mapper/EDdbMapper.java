package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EDdb;
import com.didi.po.EDdbExample;

public interface EDdbMapper {
    int countByExample(EDdbExample example);

    int deleteByExample(EDdbExample example);

    int deleteByPrimaryKey(String id);

    int insert(EDdb record);

    int insertSelective(EDdb record);

    List<EDdb> selectByExample(EDdbExample example);

    EDdb selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EDdb record, @Param("example") EDdbExample example);

    int updateByExample(@Param("record") EDdb record, @Param("example") EDdbExample example);

    int updateByPrimaryKeySelective(EDdb record);

    int updateByPrimaryKey(EDdb record);
}