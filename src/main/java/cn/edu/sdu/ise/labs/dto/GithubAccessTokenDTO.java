package cn.edu.sdu.ise.labs.dto;

import lombok.Data;

@Data
public class GithubAccessTokenDTO {
    private String clientId;
    private String clientSecret;
    private String code;
    private String redirectUri;
    private String state;
}
