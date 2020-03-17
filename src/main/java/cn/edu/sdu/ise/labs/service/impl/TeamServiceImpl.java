package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.constant.PrefixConstant;
import cn.edu.sdu.ise.labs.dao.TeamExtMapper;
import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.TeamExample;
import cn.edu.sdu.ise.labs.model.TeamExtExample;
import cn.edu.sdu.ise.labs.service.KeyMaxValueService;
import cn.edu.sdu.ise.labs.service.TeamService;
import cn.edu.sdu.ise.labs.service.utils.TeamUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private TeamExtMapper teamExtMapper;

    @Autowired
    private KeyMaxValueService keyMaxValueService;

    @Override
    public TeamVO getTeam(String teamCode) {
        if (teamCode == null) {
            throw new RuntimeException("请输入队伍号码");
        }
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamCodeEqualTo(teamCode);
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        if (teamList.size() != 1) {
            throw new RuntimeException("查询失败");
        } else {
            return TeamUtils.convertToVO(teamList.get(0));
        }
    }

    @Override
    public Page<TeamVO> listTeam(TeamQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new TeamQueryDTO();
        }
        TeamExtExample teamExample = new TeamExtExample();
        teamExample.setOrderByClause("id");
        teamExample.createCriteria()
                .andTeamNameLike(queryDTO.getTeamName())
                .andProvinceLike(queryDTO.getProvince())
                .andContactLike(queryDTO.getContact());
        List<Team> teamRawList = teamExtMapper.selectByExample(teamExample);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), teamRawList.size());
        Page<TeamVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (teamRawList.size() == 0) {
            return pageData;
        }
        teamExample.setStartRow((queryDTO.getPage() - 1) * queryDTO.getPageSize());
        teamExample.setPageSize(queryDTO.getPageSize());
        List<Team> teamList = teamExtMapper.selectByExample(teamExample);
        for (Team team : teamList) {
            pageData.getList().add(TeamUtils.convertToVO(team));
        }
        return pageData;
    }

    @Override
    public String addTeam(TeamDTO teamDTO) {
        TeamExample teamExample = new TeamExample();
        teamExample.createCriteria()
                .andTeamNameEqualTo(teamDTO.getTeamName());
        List<Team> teamList = teamMapper.selectByExample(teamExample);
        if (teamList.size() > 0) {
            throw new RuntimeException("队名已存在");
        } else {
            Team team = new Team();
            BeanUtils.copyProperties(teamDTO, team);
            TokenContextHolder.formatInsert(team);
            String teamCode = keyMaxValueService.generateBusinessCode(PrefixConstant.TEAM);
            team.setTeamCode(teamCode);
            int result = teamMapper.insert(team);
            if (result != 1) {
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
        int result = teamMapper.updateByExampleSelective(team, teamExample);
        if (result != 1) {
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