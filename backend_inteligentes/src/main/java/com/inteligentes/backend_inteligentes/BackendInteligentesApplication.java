package com.inteligentes.backend_inteligentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan("com.inteligentes")
@EnableSwagger2
@ComponentScan("springfox.documentation.spring.web.DescriptionResolver")
public class BackendInteligentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendInteligentesApplication.class, args);
	}

}
