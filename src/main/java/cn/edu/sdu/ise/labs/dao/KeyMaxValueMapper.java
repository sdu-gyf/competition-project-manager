package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.KeyMaxValue;

public interface KeyMaxValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyMaxValue record);

    int insertSelective(KeyMaxValue record);

    KeyMaxValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KeyMaxValue record);

    int updateByPrimaryKey(KeyMaxValue record);
}