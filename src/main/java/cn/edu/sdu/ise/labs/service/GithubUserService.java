package cn.edu.sdu.ise.labs.service;

import cn.edu.sdu.ise.labs.dto.GithubAccessTokenDTO;
import cn.edu.sdu.ise.labs.model.GithubUser;

public interface GithubUserService {

    String getGithubAccessToken(GithubAccessTokenDTO githubAccessTokenDTO);

    GithubUser getGithubUser(String githubAccessToken);

    void createOrUpdate(GithubUser githubUser);

}
