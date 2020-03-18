package cn.edu.sdu.ise.labs.dao;

import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.Team;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "teamMapper")
public interface TeamMapper {

    List<Team> list(
            @Param("queryDTO") TeamQueryDTO queryDTO,
            @Param("offset") Integer offset,
            @Param("limit") Integer limit);

    Team getByTeamCode(@Param("teamCode") String teamCode);

    List<Team> listByTeamName(@Param("teamName") String teamName);

    Integer count(@Param("queryDTO") TeamQueryDTO queryDTO);

    int updateByPrimaryKey(Team record);

    Team getByCode(@Param("teamCode") String teamCode);

    int insert(Team record);

    int deleteByCode(@Param("teamCode") String teamCode);
}