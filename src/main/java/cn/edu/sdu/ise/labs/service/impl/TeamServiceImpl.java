package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.service.TeamService;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Override
    public TeamVO getTeam(String teamCode) {
        return null;
    }

    @Override
    public List<TeamVO> listTeam(TeamDTO teamDTO) {
        return null;
    }

    @Override
    public String addTeam(TeamDTO teamDTO) {
        return null;
    }

    @Override
    public String updateTeam(TeamDTO teamDTO) {
        return null;
    }

    @Override
    public Long deleteTeam(List<String> teamCodes) {
        return null;
    }
}
