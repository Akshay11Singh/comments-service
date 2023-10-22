package com.comments.commentsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan({ "com.comments.controller", "com.comments.*" })
@EnableJpaRepositories("com.comments.repository")
@EntityScan("com.comments.entity")
@SpringBootApplication
@EnableSwagger2
//@EnableDiscoveryClient
public class CommentsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentsServiceApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.comments.controller")).build();
	}
}
/*
 * @RestController class EurekaClientRestController {
 * 
 * @Autowired private DiscoveryClient discoveryClient;
 * 
 * @RequestMapping("/clients/{applicationName}") public @ResponseBody String
 * getClientsByApplicationName(@PathVariable String applicationName) { return
 * this.discoveryClient.getInstances(applicationName).get(0).getUri().toString()
 * ; } }
 */