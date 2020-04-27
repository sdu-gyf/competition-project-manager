package cn.edu.sdu.ise.labs.model;

import lombok.Data;

@Data
public class GithubUser {
    private Integer id;

    private Long accountId;

    private String name;

    private String token;

    private String avatarUrl;

}