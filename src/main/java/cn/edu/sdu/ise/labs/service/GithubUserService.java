package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.GithubAccessTokenDTO;

public interface GithubUserService {

    String getGithubAccessToken(GithubAccessTokenDTO githubAccessTokenDTO);


}
