package cn.edu.sdu.ise.labs.service.utils;

import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExample;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamUtils {


    @Autowired
    private static TeamMapper teamMapper;

    public static String delete(String teamCode) {
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamCode);
        int result = teamMapper.deleteByExample(teamExample);
        if (result != 1) {
            // TODO: 2020/3/9 删除失败 异常处理
            throw new RuntimeException("删除失败");
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
