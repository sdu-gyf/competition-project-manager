package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.KeyMaxValue;

/**
 * 描述
 */
public interface KeyMaxValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KeyMaxValue record);

    KeyMaxValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(KeyMaxValue record);
}