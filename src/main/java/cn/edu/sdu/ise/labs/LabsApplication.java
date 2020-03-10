package cn.edu.sdu.ise.labs;

import cn.edu.sdu.ise.labs.service.utils.TeamUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 描述：springboot启动类
 *
 * @author 李洪文
 * @date 2019-12-3
 */
@SpringBootApplication
@EnableAsync
@Import(TeamUtils.class)
@MapperScan("cn.edu.sdu.ise.labs.dao")

public class LabsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabsApplication.class, args);
    }

}
