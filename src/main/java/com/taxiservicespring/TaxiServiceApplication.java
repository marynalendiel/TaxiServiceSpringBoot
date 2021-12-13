package com.taxiservicespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(
		scanBasePackages = {"com.taxiservicespring"})
//@EnableJpaRepositories("com.taxiservicespring.repository")
//@ComponentScan("com.taxiservicespring.repository") exclude = {DataSourceAutoConfiguration.class},
public class TaxiServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TaxiServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(TaxiServiceApplication.class, args);
	}

}
