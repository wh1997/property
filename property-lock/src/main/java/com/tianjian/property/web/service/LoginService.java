package com.tianjian.property.web.service;

import com.tianjian.property.utils.LockResult;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/12
 */
public interface LoginService {
    LockResult login(String phone,String Password) throws Exception;
}
