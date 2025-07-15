package study.min.aroundhub.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * PackageName : study.min.aroundhub.config.env
 * FileName : LocalConfiguration
 * Author : Min
 * Date : 2025-07-15
 * Description :
 */
@Profile("local")
@Configuration
public class LocalConfiguration implements EnvConfiguration {
    private final Logger LOGGER = LoggerFactory.getLogger(LocalConfiguration.class);

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    public String getMessage() {
        LOGGER.info("[getMessage] LocalConfiguration 입니다.");
        return message;
    }
}
