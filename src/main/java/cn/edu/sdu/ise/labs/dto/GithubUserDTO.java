package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class GithubUserDTO {
    /**
     * 用户名
     */
    private String login;
    /**
     * 唯一id
     */
    private Long id;
    /**
     * 头像
     */
    private String avatar_url;
}
