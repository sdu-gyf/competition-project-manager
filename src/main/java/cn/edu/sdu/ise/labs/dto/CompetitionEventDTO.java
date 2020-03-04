package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class CompetitionEventDTO {
    /**
     * 比赛项目编码
     */
    private String eventCode;
    /**
     * 比赛项目名称
     */
    private String competitionEventName;
    /**
     * 开始时间
     */
    private String planStartAt;
    /**
     * 结束时间
     */
    private String planEndAt;
    /**
     * 组别
     */
    private Integer suiteType;
    /**
     * 状态
     */
    private Integer status;
}
