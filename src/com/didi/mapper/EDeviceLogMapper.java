package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EDeviceLog;
import com.didi.po.EDeviceLogExample;

public interface EDeviceLogMapper {
    int countByExample(EDeviceLogExample example);

    int deleteByExample(EDeviceLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(EDeviceLog record);

    int insertSelective(EDeviceLog record);

    List<EDeviceLog> selectByExample(EDeviceLogExample example);

    EDeviceLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EDeviceLog record, @Param("example") EDeviceLogExample example);

    int updateByExample(@Param("record") EDeviceLog record, @Param("example") EDeviceLogExample example);

    int updateByPrimaryKeySelective(EDeviceLog record);

    int updateByPrimaryKey(EDeviceLog record);
    
    Integer getScanCodeByDeviceId(String id);
    
}