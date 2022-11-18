package pro.sky.apiSwagerPostman.hogwarts.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
@Profile("test")
public class RestTemplateConfigurationTEST implements ConfigurationRest{

    @Value(value = "${server.port}")
    private String port;

    public String getPort() {
        return port;
    }

}
