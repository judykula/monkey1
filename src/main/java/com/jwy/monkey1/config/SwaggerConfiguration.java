/*
 * easy come, easy go.
 *
 * contact : syiae.jwy@gmail.com
 *
 * · · · · ||   ..     __       ___      ____  ®
 * · · · · ||  ||  || _ ||   ||    ||   ||      ||
 * · · · · ||  ||  \\_ ||_.||    ||   \\_  ||
 * · · _//                                       ||
 * · · · · · · · · · · · · · · · · · ·· ·    ___//
 */
package com.jwy.monkey1.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * <p>
 *     swagger 配置
 * </p>
 *
 * @author Jiang Wanyu
 * @version 1.0
 * @date 2024/2/20
 */
@Configuration
public class SwaggerConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    @Profile("!prod")
    public GroupedOpenApi actuatorApi() {
        return GroupedOpenApi.builder().group("Actuator")
                .pathsToMatch("/actuator/**")
                .pathsToExclude("/actuator/health/*")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {

        Info info = new Info()
                .title("【"+this.applicationName+"】API文档")
                .description("This is a sample server Petstore server.  ")
                .version("1.0.0");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(info);
    }


}
