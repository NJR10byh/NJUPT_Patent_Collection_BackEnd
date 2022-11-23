package cn.njupt.njupt_patent_collection_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig
{

    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("pro","dev");
        boolean flag = environment.acceptsProfiles(profiles);


        return new Docket(DocumentationType.SWAGGER_2)
                .enable(flag)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.njupt.njupt_patent_collection_backend.controller"))
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "成果征集系统API文档",
                "",
                "v0.1",
                "",
                new Contact("","",""),
                "",
                "",
                new ArrayList<>()
        );
    }

}
