package pro.sky.apiSwagerPostman.hogwarts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.apiSwagerPostman.hogwarts.service.AvatarService;
import pro.sky.apiSwagerPostman.hogwarts.service.InfoService;


@RestController
@RequestMapping ("/get/port")
public class InfoController {

    private final InfoService infoService;
    private final Logger logger = LoggerFactory.getLogger(AvatarService.class);

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping()
    public String getPort() {
        logger.info("Was invoked method for get port");
        return infoService.getPort();
    }
}
