package app.project.MoviesAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"app.project.MoviesAPI", "Controller", "Service", "Repository", "Mapper", "Entity"})
@EnableJpaRepositories(basePackages = "Repository")
@EntityScan(basePackages = "Entity")
public class MoviesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApiApplication.class, args);
	}

}
