package com.tianjian.property.management.service;

import java.util.HashMap;

public interface PhoneLoginService {
    //微信授权登陆
    HashMap<String, Object> wechatLogin(String encryptedData, String iv, String code) throws Exception;

    boolean wechatLogOut(String token);
}
