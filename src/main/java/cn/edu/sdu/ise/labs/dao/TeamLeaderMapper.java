package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.TeamLeader;

public interface TeamLeaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamLeader record);

    TeamLeader selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(TeamLeader record);
}