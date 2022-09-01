package com.shine.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :Shine
 * @date : 2022-08-26 16:10
 */
@Controller
public class UserController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String Index(){
        return "Welcom HomePage";
    }
}
/**
 * @BelongsProject: springboot
 * @BelongsPackage: com.shine.springboot.controller
 * @Author: Shine
 * @CreateTime: 2022-08-26  16:10
 * @Description: TODO
 * @Version: 1.0
 */