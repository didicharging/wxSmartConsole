package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EChat;
import com.didi.po.EChatExample;

public interface EChatMapper {
    int countByExample(EChatExample example);

    int deleteByExample(EChatExample example);

    int deleteByPrimaryKey(String id);

    int insert(EChat record);

    int insertSelective(EChat record);

    List<EChat> selectByExample(EChatExample example);

    EChat selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EChat record, @Param("example") EChatExample example);

    int updateByExample(@Param("record") EChat record, @Param("example") EChatExample example);

    int updateByPrimaryKeySelective(EChat record);

    int updateByPrimaryKey(EChat record);
}