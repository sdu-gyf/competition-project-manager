package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class TeamQueryDTO {

    /**
     * 队伍名
     */
    private String teamName;
    /**
     * 省份
     */
    private String province;
    /**
     * 联系人电话
     */
    private String contact;
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 状态
     */
    private Integer status;
}
