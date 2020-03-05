package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.CompetitionEventDTO;
import cn.edu.sdu.ise.labs.vo.CompetitionEventVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "competitionEventService")
public interface CompetitionEventService {
    /**
     * 根据检索条件查询比赛项目表（athlete），返回结果记录
     *
     * @param eventCode 比赛项目编码
     * @returnC ompetitionEventVO
     */
    CompetitionEventVO getAthlete(String eventCode);

    /**
     * 根据检索条件查询比赛项目表（athlete），返回结果记录列表
     *
     * @param competitionEventDTO
     * @return List<CompetitionEventVO>
     */
    List<CompetitionEventVO> listAthlete(CompetitionEventDTO competitionEventDTO);

    /**
     * 1、	校验比赛项目注册号的唯一性，若存在报错“比赛项目注册号已经存在”
     * 2、	校验比赛项目代码的存在性，不存在报错“比赛项目不存在”
     * 3、	创建比赛项目记录，比赛项目编码自动生成，将输入的相应字段填入
     *
     * @param competitionEventDTO
     * @return 比赛项目编码
     */
    String addAthlete(CompetitionEventDTO competitionEventDTO);

    /**
     * 1、	根据比赛项目编码查询比赛项目记录，若不存在则报错
     * 2、	创建比赛项目记录，比赛项目编码自动生成，将输入的相应字段填入
     *
     * @param competitionEventDTO
     * @return 比赛项目编码
     */
    String updateAthlete(CompetitionEventDTO competitionEventDTO);

    /**
     * 目前还不知道要返回什么
     * 根据比赛项目代码，删除比赛项目记录信息
     *
     * @param competitionEventDTOList
     * @return ?
     */
    String delateAthlete(List<String> athleteCodesList);
}
