package cn.edu.sdu.ise.labs.service.impl;

import cn.edu.sdu.ise.labs.dto.GithubAccessTokenDTO;
import cn.edu.sdu.ise.labs.model.GithubUser;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.GithubUserService;
import cn.edu.sdu.ise.labs.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 李洪文
 * @date 2019/11/14 10:44
 */
@Service
@EnableScheduling
public class TokenServiceImpl implements TokenService {
    @Value("${timeout}")
    private int timeout;

    @Autowired
    private GithubUserService githubUserService;

    private Map<String, Token> tokenMap = new ConcurrentHashMap<>(1 << 8);

    /**
     * 用户登录，返回令牌信息
     *
     * @param workCode 用户id
     * @param password 密码
     * @return 令牌信息
     */
    @Override
    public Token login(String workCode, String password) {
        Token token = new Token();
        token.setAccessToken(makeToken());
        token.setTeacherName("test");
        token.setTenantCode("001");
        token.setTeacherCode("TE000001");
        token.setLastAction(new Date());
        tokenMap.put(token.getAccessToken(), token);
        return token;
    }

    @Override
    public Token githubLogin(String code) {
        Token token = new Token();
        GithubAccessTokenDTO githubAccessTokenDTO = new GithubAccessTokenDTO();
        githubAccessTokenDTO.setCode(code);
        // 获取github的accessToken
        String githubAccessToken = githubUserService.getGithubAccessToken(githubAccessTokenDTO);
        // 用accessToken去拿github的用户信息
        GithubUser githubUser = githubUserService.getGithubUser(githubAccessToken);
        // 生成本项目的token
        if(githubUser==null){
            throw new RuntimeException("Github登陆错误");
        }
        token.setAccessToken(makeToken());
        // 老师编码为github返回的唯一用户id
        token.setTeacherCode(String.valueOf(githubUser.getAccountId()));
        token.setTenantCode(String.valueOf(githubUser.getAccountId()));
        // 老师名为github用户名
        token.setTeacherName(githubUser.getName());
        githubUser.setToken(token.getAccessToken());
        // 生产用户或者更新用户信息
        githubUserService.createOrUpdate(githubUser);
        token.setAvatarUrl(githubUser.getAvatarUrl());
        tokenMap.put(token.getAccessToken(), token);
        return token;
    }

    /**
     * 根据token获取令牌信息
     *
     * @param accessToken token
     * @return 令牌信息
     */
    @Override
    public Token getToken(String accessToken) {
        return tokenMap.get(accessToken);
    }

    /**
     * 登出系统
     *
     * @param accessToken 令牌token
     */
    @Override
    public void logout(String accessToken) {

    }

    private String makeToken() { // checkException
        return UUID.randomUUID().toString().replaceAll("-", "") + "";
    }

    @Scheduled(cron = "*/20 * *  * * * ")
    public void scheduled() {
        Iterator<Map.Entry<String, Token>> iterator = tokenMap.entrySet().iterator();
        Date now = new Date();
        while (iterator.hasNext()) {
            Map.Entry<String, Token> entry = iterator.next();
            if (now.getTime() - entry.getValue().getLastAction().getTime() > 60 * timeout * 1000) {
                iterator.remove();
            }
        }
    }
}
