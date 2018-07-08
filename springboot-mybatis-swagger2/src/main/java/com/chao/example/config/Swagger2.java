package com.chao.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yaloo
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
  @Value("${swagger.show}")
  private boolean swaggerShow;
  @Value("${swagger.basepackage}")
  private String basePackage;
  @Value("${swagger.service.name}")
  private String serviceName;
  @Value("${swagger.service.description}")
  private String serviceDescription;
  @Value("${swagger.service.developer}")
  private String developer;
  @Value("${application.version}")
  private String version;

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .enable(swaggerShow)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(basePackage))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(serviceName)
        .description(serviceDescription)
        .contact(new Contact(developer, "189.cn", "yaloo_yang@189.cn"))
        .version(version)
        .build();
  }
}
