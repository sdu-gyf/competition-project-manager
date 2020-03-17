package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExtExample;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "teamExtMapper")
public interface TeamExtMapper {
    List<Team> selectByExample(TeamExtExample example);
}