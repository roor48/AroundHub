package study.min.aroundhub.config.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import study.min.aroundhub.AroundHubApplication;

/**
 * PackageName : study.min.aroundhub.config.env
 * FileName : DevConfiguration
 * Author : Min
 * Date : 2025-07-15
 * Description :
 */

@Profile("dev")
@Configuration
public class DevConfiguration implements EnvConfiguration {
    private final Logger LOGGER = LoggerFactory.getLogger(DevConfiguration.class);

    @Value("${around.hub.loading.message}")
    private String message;

    @Override
    public String getMessage() {
        LOGGER.info("[getMessage] DevConfiguration 입니다.");
        return message;
    }
}
