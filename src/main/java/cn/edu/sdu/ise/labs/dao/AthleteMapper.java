package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Athlete;
import cn.edu.sdu.ise.labs.model.AthleteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AthleteMapper {
    int countByExample(AthleteExample example);

    int deleteByExample(AthleteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Athlete record);

    int insertSelective(Athlete record);

    List<Athlete> selectByExample(AthleteExample example);

    Athlete selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Athlete record, @Param("example") AthleteExample example);

    int updateByExample(@Param("record") Athlete record, @Param("example") AthleteExample example);

    int updateByPrimaryKeySelective(Athlete record);

    int updateByPrimaryKey(Athlete record);
}