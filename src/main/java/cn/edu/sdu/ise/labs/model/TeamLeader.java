package cn.edu.sdu.ise.labs.model;

import lombok.Data;

import java.util.Date;

@Data
public class TeamLeader {
    private Integer id;

    private String teamCode;

    private String leaderName;

    private String leaderJob;

    private String ethnicity;

    private String gender;

    private String idNumber;

    private String idType;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;

}