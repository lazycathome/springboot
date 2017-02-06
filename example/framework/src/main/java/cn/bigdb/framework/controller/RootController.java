package cn.bigdb.framework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    public static final String PATH_ROOT = "/";

    @RequestMapping(PATH_ROOT)
    public String welcome() {
        return "Welcome!";
    }

}