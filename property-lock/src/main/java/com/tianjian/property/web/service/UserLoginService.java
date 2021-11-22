package com.tianjian.property.web.service;

import com.tianjian.property.bean.Auth;
import com.tianjian.property.bean.UserRole;
import com.tianjian.property.utils.LockResult;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/12
 */
public interface UserLoginService {
    LockResult login(String phone,String Password) throws Exception;

    int addRole(UserRole userRole);

    int deleteRole(Integer urId);

    List<Map> selectRole(Integer userId);

    int addRight(Auth auth);

    int deleteRight(Integer aId,String type);

    List<Map> propertyRight(List<Integer> roleId);
}
