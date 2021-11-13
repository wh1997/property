package com.tianjian.property.web.controller;

import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/12
 */
@Controller
@RequestMapping("/web/user")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public LockResult login(Map map) {
        String phone = (String) map.get("phone");
        try {
            return loginService.login(phone);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(true,"登录失败", ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
    }

}
