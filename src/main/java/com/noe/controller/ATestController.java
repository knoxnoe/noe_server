package com.noe.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @descriptions:
 * @author: noe
 * @date:
 */
@RestController
//@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {})
public class ATestController {

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {

        System.out.println("test");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("auth/2step-code")
    public boolean get2step() {
        return true;
    }


}
