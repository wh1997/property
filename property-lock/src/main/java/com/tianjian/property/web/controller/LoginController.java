package com.tianjian.property.web.controller;

import com.tianjian.property.utils.LockResult;
import com.tianjian.property.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/12
 */
@RestController
@RequestMapping("/web/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public LockResult login(@RequestBody Map map) throws Exception {
        String phone = (String) map.get("phone");
        String Password = (String) map.get("password");
        LockResult login = loginService.login(phone, Password);
        return  login;
    }

}
