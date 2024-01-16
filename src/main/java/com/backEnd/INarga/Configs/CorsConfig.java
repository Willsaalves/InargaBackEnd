package com.backEnd.INarga.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://192.168.15.50:8081") // Substitua pelo endereço do seu																// frontend Expo
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
