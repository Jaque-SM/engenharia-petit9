package api.enginner_peti9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"api.enginner_peti9.repository"})
public class EnginnerPeti9Application {
	public static void main(String[] args) {
		SpringApplication.run(EnginnerPeti9Application.class, args);
	}
}
