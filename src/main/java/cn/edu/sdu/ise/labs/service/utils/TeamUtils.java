package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dao.AthleteMapper;
import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.model.Athlete;
import cn.edu.sdu.ise.labs.model.AthleteExample;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExample;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class TeamUtils {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private AthleteMapper athleteMapper;

    private static TeamMapper teamMapperNew;

    private static AthleteMapper athleteMapperNew;

    @PostConstruct
    public void init() {
        teamMapperNew = teamMapper;
        athleteMapperNew = athleteMapper;
    }

    public static String delete(String teamCode) {
        AthleteExample athleteExample = new AthleteExample();
        athleteExample.createCriteria()
                .andTeamCodeEqualTo(teamCode);
        List<Athlete> athleteList = athleteMapperNew.selectByExample(athleteExample);
        if (athleteList != null || athleteList.size() != 0) {
            throw new RuntimeException("删除失败,该队伍有运动员");
        }
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamCode);
        int result = teamMapperNew.deleteByExample(teamExample);
        if (result != 1) {
            throw new RuntimeException("删除失败或该队伍不存在");
        }
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
