package cn.edu.sdu.ise.labs.controller;

import cn.edu.sdu.ise.labs.model.ResultContext;
import cn.edu.sdu.ise.labs.model.Token;
import cn.edu.sdu.ise.labs.service.GithubUserService;
import cn.edu.sdu.ise.labs.service.TokenService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李洪文
 * @description 系统控制器，包含登录
 * @date 2019/11/14 10:45
 */
@RestController
@RequestMapping("system")
public class SystemController {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private GithubUserService githubUserService;

    @GetMapping("login")
    public ResultContext login(String workCode, String password) {
        Token token = tokenService.login(workCode, password);
        return ResultContext.returnSuccess(token);
    }

    @GetMapping("callback")
    public ResultContext callback(@Param("code") String code) {
        Token token = tokenService.githubLogin(code);
        return ResultContext.returnSuccess(token);
    }

    @GetMapping("user")
    public ResultContext getUser(@Param("accessToken") String accessToken) {
        return ResultContext.returnSuccess();
    }

    @GetMapping("ping")
    public ResultContext ping() {
        return ResultContext.returnSuccess("done");
    }
}
