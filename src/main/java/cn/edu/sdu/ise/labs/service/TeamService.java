package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.TeamDTO;
import cn.edu.sdu.ise.labs.dto.TeamQueryDTO;
import cn.edu.sdu.ise.labs.model.Page;
import cn.edu.sdu.ise.labs.vo.TeamVO;

import java.util.List;

public interface TeamService {
    /**
     * 根据检索条件查询参赛队伍表（team），返回结果记录
     *
     * @param teamCode
     * @return TeamVO
     */
    TeamVO getTeam(String teamCode);

    /**
     * @param queryDTO
     * @return 根据检索条件查询参赛队伍表（team），返回结果记录列表
     */
    Page<TeamVO> listTeam(TeamQueryDTO queryDTO);

    /**
     * 1、	校验代表队名称的唯一性，若存在报错“队伍名称已经存在”
     * 2、	创建队伍记录，队伍编码自动生成，将输入的相应字段填入
     *
     * @param teamDTO
     * @return
     */
    String addTeam(TeamDTO teamDTO);

    /**
     * 1、	根据代表队编码查询代表队记录，若不存在则报错
     * 2、	校验代表队名称的唯一性，若存在报错“队伍名称已经存在”
     * 3、	创建队伍记录，队伍编码自动生成，将输入的相应字段填入
     *
     * @param teamDTO
     * @return
     */
    String updateTeam(TeamDTO teamDTO);

    /**
     * 1、	根据代表队编码查询运动员表，如果有记录，则报错“有运动员属于该代表队，不能删除”
     * 2、	根据代表队代码，删除代表队记录信息
     *
     * @param teamCodes
     * @return
     */
    int deleteTeam(List<String> teamCodes);
}
