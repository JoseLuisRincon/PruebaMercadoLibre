package com.mercadolibre.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroservicioApiMercadolibreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApiMercadolibreApplication.class, args);
	}

}
