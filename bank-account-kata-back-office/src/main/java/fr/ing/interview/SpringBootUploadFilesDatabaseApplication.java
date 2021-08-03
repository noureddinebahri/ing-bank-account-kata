package fr.ing.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootUploadFilesDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUploadFilesDatabaseApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/upload").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}
}
