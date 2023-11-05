package com.martinez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;

import com.martinez.customers.domain.Customer;

@SpringBootApplication
@EntityScan( basePackageClasses = {Customer.class, Long.class} )
public class AppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(AppApplication.class, args);
		configurableApplicationContext.start();
	}
}
