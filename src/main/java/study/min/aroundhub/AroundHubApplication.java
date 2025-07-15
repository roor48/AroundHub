package study.min.aroundhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AroundHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AroundHubApplication.class, args);
	}

}
