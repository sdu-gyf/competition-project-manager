package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class TeamDTO {
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
     * 队伍编号
     */
    private String teamCode;
}
