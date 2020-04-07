package com.leyou.item.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author huangcf
 * @Description
 * Swagger2的配置类
 * @Date  2020/3/24 10:16
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean("Authority")
    public Docket apiAuthority() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("权限模块接口")
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.leyou.item.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean("Test")
    public Docket apiTest() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("测试模块接口")
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("com.leyou.item.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("模块接口")
                .description("")//swagger UI接入教程
                //服务条款网
                .termsOfServiceUrl("")
                //版本号
                .version("1.0")
                .build();
    }

}
