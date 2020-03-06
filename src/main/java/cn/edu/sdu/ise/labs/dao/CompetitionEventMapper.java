package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.CompetitionEventExt;

public interface CompetitionEventMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionEventExt record);

    int insertSelective(CompetitionEventExt record);

    CompetitionEventExt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompetitionEventExt record);

    int updateByPrimaryKey(CompetitionEventExt record);
}