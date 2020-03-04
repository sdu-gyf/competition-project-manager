package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

@Data
public class CompetitionEventVO {
    /**
     * 比赛项目编码
     */
    private String competitionEventCode;
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
     * 组别名称
     */
    private String suiteTypeDesc;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 状态描述
     */
    private String statusDesc;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    private String updatedAt;
    /**
     * 更新人
     */
    private String updatedBy;

}
