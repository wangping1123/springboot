package com.wp;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wangping
 * @EnableSwagger2 注解开启 swagger2 功能
 * @Configuration 注解标示, 这是一个配置类,@Configuation注解包含了@Component注解
 * 可以不用在使用@Component注解标记这是个bean了
 * swagger2配置文件
 */
@EnableSwagger2
@Configuration
public class Swagger2Config implements WebMvcConfigurer {


    /**
     * 将Swagger2 的swagger-ui.html加入资源路径下,否则Swagger2静态页面不能访问。要想使资源能够访问，可以有两种方法
     * 一：需要配置类继承WebMvcConfigurationSupport 类，实现addResourceHandlers方法。
     * 但是实现了WebMvcConfigurationSupport以后，Spring Boot的 WebMvc自动配置就会失效，具体表现比如访问不到
     * 静态资源（js，css等）了，这是因为WebMvc的自动配置都在WebMvcAutoConfiguration类中，但是类中有这个注解
     *
     * @param registry
     * @ConditionalOnMissingBean({WebMvcConfigurationSupport.class})，意思是一旦在容器中检测到 WebMvcConfigurationSupport这个类，WebMvcAutoConfiguration类中的配置都不生效。
     * 所以一旦我们自己写的配置类继承了WebMvcConfigurationSupport，相当于容器中已经有了WebMvcConfigurationSupport，
     * 所有默认配置都不会生效，都得自己在配置文件中配置。
     * 二：继承WebMvcConfigurer接口，这里采用此方法 网上有人说使用该方法会导致date编译等问题，可能在配置文件中得到解决，
     * 本人没有碰到，不多做解释
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     * 接口文档默认访问路径http://localhost:8080/swagger-ui.html
     * 注解说明参考博客：https://blog.csdn.net/qq_28009065/article/details/79104103，
     */
    @Bean
    public Docket commonDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用API接口文档")
                .apiInfo(apiInfo("测试环境通用接口"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wp"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket normalUserDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("普通用户API文档")
                .apiInfo(apiInfo("提供普通用户接口"))
                .protocols(Sets.newHashSet("https", "http"))
                .produces(Sets.newHashSet("html/text"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wp"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket companyUserDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("企业用户API接口文档")
                .apiInfo(apiInfo("提供企业用户接口"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wp"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 文档信息
     *
     * @param desc
     * @return
     */
    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                //页面标题
                .title(desc)
                //设置作者联系方式,可有可无
                .contact(new Contact("wangping", "http://www.google.com", "xxxx@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}