package com.tianjian.property.management.service.impl;

import com.tianjian.property.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/9/27
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public Object selectUserByRole(Integer appUID) {
        userDao.selectUserByRole(appUID);
        return null;
    }
}
