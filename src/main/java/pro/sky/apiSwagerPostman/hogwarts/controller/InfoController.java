package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.apiSwagerPostman.hogwarts.configuration.ConfigurationRest;
import pro.sky.apiSwagerPostman.hogwarts.configuration.RestTemplateConfiguration;


@RestController
@RequestMapping ("/get/port")
public class InfoController {

    @Autowired
    ConfigurationRest configurationRest;
    @GetMapping()
    public String getPort() {
        return configurationRest.getPort();
    }
}
