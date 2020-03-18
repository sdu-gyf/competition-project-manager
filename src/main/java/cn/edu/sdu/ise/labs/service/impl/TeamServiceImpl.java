package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.constant.PrefixConstant;
import cn.edu.sdu.ise.labs.dao.TeamMapper;
import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.model.Team;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.KeyMaxValueService;
import cn.edu.sdu.ise.labs.service.TeamService;
import cn.edu.sdu.ise.labs.service.utils.TeamUtils;
import cn.edu.sdu.ise.labs.utils.FormatUtils;
import cn.edu.sdu.ise.labs.utils.PageUtils;
import cn.edu.sdu.ise.labs.utils.TokenContextHolder;
import cn.edu.sdu.ise.labs.vo.TeamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private KeyMaxValueService keyMaxValueService;

    @Override
    public TeamVO getTeam(String teamCode) {
        if (teamCode == null) {
            throw new RuntimeException("请输入队伍号码");
        }
        Team team = teamMapper.getByTeamCode(teamCode);
        return TeamUtils.convertToVO(team);
    }

    @Override
    public Page<TeamVO> listTeam(TeamQueryDTO queryDTO) {
        if (queryDTO == null) {
            queryDTO = new TeamQueryDTO();
        }
        if (queryDTO.getTeamName() != null) {
            queryDTO.setProvince(FormatUtils.makeFuzzySearchTerm(queryDTO.getProvince()));
        }
        if (queryDTO.getTeamName() != null) {
            queryDTO.setTeamName(FormatUtils.makeFuzzySearchTerm(queryDTO.getTeamName()));
        }
        if (queryDTO.getContact() != null) {
            queryDTO.setContact(FormatUtils.makeFuzzySearchTerm(queryDTO.getContact()));
        }
        Integer size = teamMapper.count(queryDTO);
        PageUtils pageUtils = new PageUtils(queryDTO.getPage(), queryDTO.getPageSize(), size);
        Page<TeamVO> pageData = new Page<>(pageUtils.getPage(), pageUtils.getPageSize(), pageUtils.getTotal(), new ArrayList<>());
        if (size == 0) {
            return pageData;
        }
        List<Team> teamList = teamMapper.list(queryDTO, pageUtils.getOffset(), pageUtils.getLimit());
        for (Team team : teamList) {
            pageData.getList().add(TeamUtils.convertToVO(team));
        }
        return pageData;
    }

    @Override
    public String addTeam(TeamDTO teamDTO) {
        List<Team> teamList = teamMapper.listByTeamName(teamDTO.getTeamName());
        if (teamList.size() > 0) {
            throw new RuntimeException("队名已存在");
        } else {
            Team team = new Team();
            BeanUtils.copyProperties(teamDTO, team);
            TokenContextHolder.formatInsert(team);
            Date date = new Date();
            team.setCreatedAt(date);
            team.setUpdatedAt(date);
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
        Token token = TokenContextHolder.getToken();
        Team team = teamMapper.getByCode(teamDTO.getTeamCode());
        Assert.notNull(team, "未找到队伍，代码为：" + teamDTO.getTeamCode());
        BeanUtils.copyProperties(teamDTO, team);
        team.setUpdatedBy(token.getTenantCode());
        team.setUpdatedAt(new Date());
        teamMapper.updateByPrimaryKey(team);
        return teamDTO.getTeamCode();
    }

    @Override
    public int deleteTeam(List<String> teamCodes) {
        TokenContextHolder.getToken();
        return (int) teamCodes.stream()
                .map(TeamUtils::delete).count();
    }
}