package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExtExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "teamExtMapper")
public interface TeamExtMapper {
    List<Team> selectByExample(TeamExtExample example);

    List<Team> list(
            @Param("queryDTO") TeamQueryDTO queryDTO,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit);

    Integer count(@Param("queryDTO") TeamQueryDTO queryDTO);
}