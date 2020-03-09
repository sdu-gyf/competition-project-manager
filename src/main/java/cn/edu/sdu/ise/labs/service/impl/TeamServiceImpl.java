package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExample;
import cn.edu.sdu.ise.labs.service.TeamService;
import cn.edu.sdu.ise.labs.service.utils.TeamUtils;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public TeamVO getTeam(String teamCode) {
        if (teamCode == null) {
            // TODO: 2020/3/9  异常处理 teamCode为空的时候。
            throw new RuntimeException("请输入队伍号码");
        }
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamCode);
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        if (teamList.size() != 1) {
            // TODO: 2020/3/9 查询结果不唯一或者不存在的时候异常处理。
            throw new RuntimeException("查询失败");
        } else {
            return TeamUtils.convertToVO(teamList.get(0));
        }
    }

    @Override
    public List<TeamVO> listTeam(TeamDTO teamDTO) {
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamDTO.getTeamName())
                .andProvinceGreaterThanOrEqualTo(teamDTO.getProvince())
                .andContactEqualTo(teamDTO.getContact());
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        return teamList.stream()
                .map(TeamUtils::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public String addTeam(TeamDTO teamDTO) {
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamNameEqualTo(teamDTO.getTeamName());
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        if (teamList != null) {
            // TODO: 2020/3/9 队名已存在的异常处理。
            throw new RuntimeException("队名已存在");
        } else {
            Team team = new Team();
            BeanUtils.copyProperties(teamDTO, team);
            Date date = new Date();
            team.setCreatedAt(date);
            team.setUpdatedAt(date);
            team.setCreatedBy("admin");
            team.setUpdatedBy("admin");
            String rdm = String.valueOf(Math.abs(new Random().nextInt()));
            String teamCode = teamDTO.getTeamName() + rdm;
            team.setTeamCode(teamCode);
            int result = teamMapper.insert(team);
            if (result != 1) {
                // TODO: 2020/3/9 添加报错异常处理。
                throw new RuntimeException("添加失败");
            } else {
                return teamCode;
            }
        }
    }

    @Override
    public String updateTeam(TeamDTO teamDTO) {
        Team team = new Team();
        BeanUtils.copyProperties(teamDTO, team);
        team.setUpdatedAt(new Date());
        team.setUpdatedBy("new admin");
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamDTO.getTeamCode());
        int result = teamMapper.updateByExample(team, teamExample);
        if (result != 1) {
            // TODO: 2020/3/9 异常处理
            throw new RuntimeException("更新失败");
        } else {
            return teamDTO.getTeamCode();
        }
    }

    @Override
    public int deleteTeam(List<String> teamCodes) {
        return (int) teamCodes.stream()
                .map(TeamUtils::delete).count();
    }
}