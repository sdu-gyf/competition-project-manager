package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

/**
 * 描述：比赛实体类
 *
 * @author 高逸飞
 * @date 2020-3-5
 */
@Data
public class CompetitionEvent {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 比赛项目编码，自动生成，全局唯一
     */
    private String competitionEventCode;
    /**
     * 比赛项目名称
     */
    private String competitionEventName;
    /**
     * 组别
     */
    private Integer suiteType;
    /**
     * 计划开始日期
     */
    private Date planStartAt;
    /**
     * 计划结束日期
     */
    private Date planEndAt;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新人
     */
    private String updatedBy;

}