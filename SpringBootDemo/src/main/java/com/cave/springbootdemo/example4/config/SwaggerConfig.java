package com.cave.springbootdemo.example4.config;

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
 * Swagger2注解相关信息：http://docs.swagger.io/swagger-core/apidocs/com/wordnik/swagger/annotations/package-summary.html
 * Swagger2官方网站：https://swagger.io/
 *
 * 还是有很多内容可以作为参数的
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建Docket对象，添加apiInfo，扫描Controller包
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cave.springbootdemo.example4.web"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建API基本描述信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://yequan94.github.io")
                .termsOfServiceUrl("http://yequan94.github.io")
                .contact("YeQuan94")
                .version("1.0")
                .build();
    }

}
