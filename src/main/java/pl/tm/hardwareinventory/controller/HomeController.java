package pl.tm.hardwareinventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
                                    /*@RequestMapping("/sample-logger")
                                    @ResponseBody
                                    public String sample() {
                                    logger.info("simple log");
                                    int a = 2;
                                    int b = 5;
                                    logger.debug("a = {}, b = {} ", a, b);
                                    return "sample";
                                    }*/



    @RequestMapping("/")
    public String homePage(){

        logger.info("!!!!!!Welcome in Hardware Inventory App!!!!!!");
        return"index";
    }
}
