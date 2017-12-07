package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EDevice;
import com.didi.po.EDeviceExample;

public interface EDeviceMapper {
    int countByExample(EDeviceExample example);

    int deleteByExample(EDeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(EDevice record);

    int insertSelective(EDevice record);

    List<EDevice> selectByExample(EDeviceExample example);

    EDevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EDevice record, @Param("example") EDeviceExample example);

    int updateByExample(@Param("record") EDevice record, @Param("example") EDeviceExample example);

    int updateByPrimaryKeySelective(EDevice record);

    int updateByPrimaryKey(EDevice record);
}