package cn.edu.sdu.ise.labs.vo;

import lombok.Data;

@Data
public class TeamVO {
    /**
     * 参赛队伍编码
     */
    private String teamCode;
    /**
     * 代表队名称
     */
    private String teamName;
    /**
     * 所在省
     */
    private String province;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 备注
     */
    private String description;
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
