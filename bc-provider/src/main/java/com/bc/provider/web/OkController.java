package com.bc.provider.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OkController {

    @RequestMapping("/ok")
    public String ok(){
        return "ok";
    }
}
