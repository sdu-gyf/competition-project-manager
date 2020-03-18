package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dao.AthleteMapper;
import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TeamUtils {

    @Autowired
    private TeamMapper teamExtMapper;

    @Autowired
    private AthleteMapper athleteMapper;

    private static TeamMapper teamMapperNew;

    private static AthleteMapper athleteMapperNew;

    @PostConstruct
    public void init() {
        teamMapperNew = teamExtMapper;
        athleteMapperNew = athleteMapper;
    }

    public static String delete(String teamCode) {
        Integer athleteNum = athleteMapperNew.countByTeamCode(teamCode);
        if (athleteNum > 0) {
            throw new RuntimeException("删除失败,该队伍有运动员");
        }
        teamMapperNew.deleteByCode(teamCode);
        return null;
    }

    public static TeamVO convertToVO(Team team) {
        TeamVO teamVO = new TeamVO();
        BeanUtils.copyProperties(team, teamVO);
        teamVO.setCreatedAt(FormatUtils.formatFullDate(team.getCreatedAt()));
        teamVO.setUpdatedAt(FormatUtils.formatFullDate(team.getUpdatedAt()));
        return teamVO;
    }
}
