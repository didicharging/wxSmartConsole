package com.didi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.didi.po.DAdmin;
import com.didi.po.DAdminExample;

public interface DAdminMapper {
    int countByExample(DAdminExample example);

    int deleteByExample(DAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DAdmin record);

    int insertSelective(DAdmin record);

    List<DAdmin> selectByExample(DAdminExample example);

    DAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DAdmin record, @Param("example") DAdminExample example);

    int updateByExample(@Param("record") DAdmin record, @Param("example") DAdminExample example);

    int updateByPrimaryKeySelective(DAdmin record);

    int updateByPrimaryKey(DAdmin record);
}