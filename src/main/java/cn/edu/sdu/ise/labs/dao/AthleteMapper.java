package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Athlete;

public interface AthleteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Athlete record);

    int insertSelective(Athlete record);

    Athlete selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Athlete record);

    int updateByPrimaryKey(Athlete record);
}