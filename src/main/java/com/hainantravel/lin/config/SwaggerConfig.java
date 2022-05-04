package com.hainantravel.lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author: Lin
 * @time: 2020/12/16 19:14
 * @Description: TODO
 */

//要被配置到spring里面，需要添加config注解
@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {
    @Bean//配置docket以配置Swagger具体参数
    public Docket docket() {
        //覆盖原来默认的配置信息
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.hainantravel.lin.controller"))
                // 配置如何通过path过滤,即这里用正则表达式只扫描请求以/kuang开头的接口
                .paths(PathSelectors.any())
                .build();
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("联系人杨瀚林", "http://xxx.xxx.com/联系人访问链接", "1258597126@qq.com");
        //配置对象
        return new ApiInfo(
                "智慧海南旅游景点管理端接口文档", // 标题
                "智慧海南旅游景点管理端接口文档", // 描述
                "v1.0", // 版本
                "此处输入可以联系的组织网站", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()// 扩展
        );
    }
}
