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
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.HeaderParameter;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
//@Profile("!prod")
public class SwaggerConfiguration {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public GroupedOpenApi webMvcApi() {
        return GroupedOpenApi.builder().group("WebMvc")
                .packagesToScan("com.jwy.monkey1.web")
                .build();
    }

    @Bean
    public GroupedOpenApi feignApi() {
        return GroupedOpenApi.builder().group("Feign")
                .packagesToScan("com.jwy.monkey1.feign.server")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {

        Info info = new Info()
                .title("【"+this.applicationName+"】API文档")
                .description("This is a sample server Petstore server.  ")
                .version("1.7.0");

        return new OpenAPI()
                .components( new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
                        .addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1"))
                        .addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema()))
                        .addParameters("myGlobalHeader", new HeaderParameter()
                                .required(true)
                                .name("My-Global-Header")
                                .description("My Global Header")
                                .schema(new StringSchema())
                        )
                )
                .info(info);
    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> openApi.getPaths().values().stream().flatMap(pathItem -> pathItem.readOperations().stream())
                .forEach(operation -> operation.addParametersItem(new HeaderParameter().$ref("myHeader2")));
    }

}
