package tv.alphanetworks.training.video_store.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This is a default class , should be updated to work
 */

@Getter
@Setter
@Configuration
@ConfigurationProperties("custom")
public class StoreConfiguration {
    private int maxDuration;
    private double vat;
}
