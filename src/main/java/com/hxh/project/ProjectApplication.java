package com.hxh.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author huangxunhui
 * Date: Created in 2019-03-12 11:29
 * Utils: Intellij Idea
 * Description: 启动类
 */
@SpringBootApplication
@MapperScan("com.hxh.project.mapper")
public class ProjectApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjectApplication.class);
    }

}
