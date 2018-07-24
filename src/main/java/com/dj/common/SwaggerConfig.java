package com.dj.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongjie on 2018/6/14.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        List operationParameters = new ArrayList();

        ParameterBuilder paramb = new ParameterBuilder();
        paramb.name("Authorization")
                .parameterType("header")
                .defaultValue("")
                .description("授权码,如果需要登录,请传入")
                .modelRef(new ModelRef("String"));

        operationParameters.add(paramb.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(new MyPredicate())
                .build()
                .globalOperationParameters(operationParameters);
    }

    private class MyPredicate implements com.google.common.base.Predicate<String> {
        AntPathMatcher matcher = new AntPathMatcher();
        private String[] PATHS = new String[]{"/api/user/**","/api/student/**"};

        @Override
        public boolean apply(String input) {
            for (int i = 0; i < PATHS.length; i++) {
                if (matcher.match(PATHS[i], input))
                    return true;
            }

            return false;
        }

    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .version("1.0")
                .build();
    }

}
