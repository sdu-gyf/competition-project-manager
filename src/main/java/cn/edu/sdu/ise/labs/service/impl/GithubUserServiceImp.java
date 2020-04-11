package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dto.GithubAccessTokenDTO;
import cn.edu.sdu.ise.labs.service.GithubUserService;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GithubUserServiceImp implements GithubUserService {

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Value("${github.client_secret}")
    private String clientSecret;

    @Override
    public String getGithubAccessToken(GithubAccessTokenDTO githubAccessTokenDTO) {
        githubAccessTokenDTO.setClientId(clientId);
        githubAccessTokenDTO.setClientSecret(clientSecret);
        githubAccessTokenDTO.setRedirectUri(redirectUri);
        githubAccessTokenDTO.setState("1");
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON.toJSONString(githubAccessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String access_token = response.body().string();
            String token = access_token.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
