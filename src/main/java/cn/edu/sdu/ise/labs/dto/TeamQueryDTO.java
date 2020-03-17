package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class TeamQueryDTO {

    private String teamName;

    private String province;

    private String contact;
    /**
     * 页码
     */
    private Integer page;

    /**
     * 每页记录数
     */
    private Integer pageSize;
}
