package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TeamDTO {
    /**
     * 代表队名称
     */
    @NotEmpty(message = "队伍名不能为空")
    private String teamName;
    /**
     * 所在省
     */
    @NotEmpty(message = "省份不能为空")
    private String province;
    /**
     * 联系人
     */
    @NotEmpty(message = "联系人不能为空")
    private String contact;

    /**
     * 联系电话
     */
    @NotEmpty(message = "联系电话不能为空")
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
