package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.EOrders;
import com.didi.po.EOrdersExample;

public interface EOrdersMapper {
    int countByExample(EOrdersExample example);

    int deleteByExample(EOrdersExample example);

    int deleteByPrimaryKey(String id);

    int insert(EOrders record);

    int insertSelective(EOrders record);

    List<EOrders> selectByExample(EOrdersExample example);

    EOrders selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EOrders record, @Param("example") EOrdersExample example);

    int updateByExample(@Param("record") EOrders record, @Param("example") EOrdersExample example);

    int updateByPrimaryKeySelective(EOrders record);

    int updateByPrimaryKey(EOrders record);
}