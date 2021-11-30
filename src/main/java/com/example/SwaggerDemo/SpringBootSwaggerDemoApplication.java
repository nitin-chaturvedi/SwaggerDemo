package com.example.SwaggerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import java.util.Collections;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringBootSwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerDemoApplication.class, args);
	}

  @Bean
  public Docket swaggerConfiguration(){
    //This is used for Configuring Swagger
    //Docket instance is configured by following builder pattern use select to get builder object put all properties and then build
    //Here we are using path selector to /api/* as we want swagger to create documentation only for api which we create and skip for spring error api and any other path
    //with help of base package we can further limit the scan to only the Business application related package and skip other packages like spring configurations and models
    return new Docket(DocumentationType.SWAGGER_2)
      .select()
      .paths(PathSelectors.ant("/api/*"))
      .apis(RequestHandlerSelectors.basePackage("com.example.SwaggerDemo"))
      .build()
      .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo(){
    return new ApiInfo(
      "Swagger Demo",
      "Demo project for Swagger with Spring Boot",
      "1.0",
      "Free to use",
      new Contact("Nitin Chaturvedi","https://www.linkedin.com/in/nitin-chaturvedi-b2348333","test@test.com"),
      "API Liscense",
      "https://www.linkedin.com/in/nitin-chaturvedi-b2348333",
      Collections.emptyList()
    );
  }

}
