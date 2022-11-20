package pro.sky.apiSwagerPostman.hogwarts.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class InfoService {

    @Value(value = "${server.port}")
    private String port;

    public String getPort() {
        return port;
    }

}
