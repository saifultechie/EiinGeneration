package com.eiin.institutionEiinGenerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.eiin.institutionEiinGenerate")
@SpringBootApplication
public class InstitutionEiinGenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstitutionEiinGenerateApplication.class, args);
	}

}
