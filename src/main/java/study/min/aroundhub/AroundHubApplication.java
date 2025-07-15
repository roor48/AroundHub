package study.min.aroundhub;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.min.aroundhub.config.ProfileManager;
import study.min.aroundhub.config.env.EnvConfiguration;

@SpringBootApplication
public class AroundHubApplication {

	private final Logger LOGGER = LoggerFactory.getLogger(AroundHubApplication.class);

	@Autowired
	public AroundHubApplication(EnvConfiguration envConfiguration, ProfileManager profileManager) {
		LOGGER.info(envConfiguration.getMessage());
		profileManager.printActiveProfiles();
	}

	public static void main(String[] args) {
		SpringApplication.run(AroundHubApplication.class, args);
	}

}
