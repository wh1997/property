package com.tianjian.property.web.service.impl;

import com.tianjian.property.bean.Property;
import com.tianjian.property.dao.RolePropertyDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.web.service.SelectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Service
public class SelectRoleServiceImpl implements SelectRoleService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RolePropertyDao rolePropertyDao;
    @Override
    public List<Integer> selectRole(Integer userId){
        //查询用户的角色
        List<Integer> list = userDao.selectRoleByUserId(userId);
        //查询该角色管理的项目(百为项目id)
        List<Integer> properties = rolePropertyDao.selectPropertyByRoleId(list);
        return properties;
    }
}
