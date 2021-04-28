package com.manager.order.managerorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.manager.order.managerorder.controller.UsuarioController;

@SpringBootApplication
@EnableConfigurationProperties
public class ManagerorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerorderApplication.class, args);
	}

}
