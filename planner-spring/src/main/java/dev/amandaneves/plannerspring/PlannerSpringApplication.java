package dev.amandaneves.plannerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/api")
public class PlannerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerSpringApplication.class, args);
	}

	@GetMapping
	public String helloWorld() {
		return "Hello World!";
	}
}
