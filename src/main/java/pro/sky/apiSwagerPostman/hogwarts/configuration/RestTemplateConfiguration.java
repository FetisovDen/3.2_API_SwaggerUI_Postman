package pro.sky.apiSwagerPostman.hogwarts.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class RestTemplateConfiguration implements ConfigurationRest {

    @Value(value = "${server.port}")
    private String port;

    @Override
    public String getPort() {
        return port;
    }

}
