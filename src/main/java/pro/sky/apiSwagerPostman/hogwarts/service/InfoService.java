package pro.sky.apiSwagerPostman.hogwarts.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.Stream;

@Configuration
@Profile("!test")
public class InfoService {

    @Value(value = "${server.port}")
    private String port;

    public String getPort() {
        return port;
    }
    public Long getDouble(){
        return Stream.iterate(1, a -> a +1).limit(1_000_000).mapToLong(Integer::longValue).sum();
    }

}
