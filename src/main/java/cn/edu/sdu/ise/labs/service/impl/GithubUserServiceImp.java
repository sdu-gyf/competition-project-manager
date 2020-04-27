package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dao.GithubUserMapper;
import cn.edu.sdu.ise.labs.dto.GithubAccessTokenDTO;
import cn.edu.sdu.ise.labs.dto.GithubUserDTO;
import cn.edu.sdu.ise.labs.model.GithubUser;
import cn.edu.sdu.ise.labs.service.GithubUserService;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class GithubUserServiceImp implements GithubUserService {

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Value("${github.client_secret}")
    private String clientSecret;

    @Autowired
    private GithubUserMapper githubUserMapper;

    @Override
    public String getGithubAccessToken(GithubAccessTokenDTO githubAccessTokenDTO) {
        githubAccessTokenDTO.setClient_id(clientId);
        githubAccessTokenDTO.setClient_secret(clientSecret);
        githubAccessTokenDTO.setRedirect_uri(redirectUri);
        githubAccessTokenDTO.setState("1");
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");


        RequestBody body = RequestBody.create(JSON.toJSONString(githubAccessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            String access_token = Objects.requireNonNull(response.body()).string();
            // 这是返回token
            return access_token.split("&")[0].split("=")[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GithubUser getGithubUser(String githubAccessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + githubAccessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String data = Objects.requireNonNull(response.body()).string();
            GithubUserDTO githubUserDTO = JSON.parseObject(data, GithubUserDTO.class);
            GithubUser githubUser = new GithubUser();
            githubUser.setAccountId(githubUserDTO.getId());
            githubUser.setAvatarUrl(githubUserDTO.getAvatar_url());
            githubUser.setName(githubUserDTO.getLogin());
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createOrUpdate(GithubUser githubUser) {
        // 根据id查有没有记录，如果没有就insert
        GithubUser newGithubUser = githubUserMapper.selectByAccountId(githubUser.getAccountId());
        if(newGithubUser != null){
            // 如果有就update
            newGithubUser.setToken(githubUser.getToken());
            githubUserMapper.updateByPrimaryKey(newGithubUser);
        }else {
            githubUserMapper.insert(githubUser);
        }
    }
}
