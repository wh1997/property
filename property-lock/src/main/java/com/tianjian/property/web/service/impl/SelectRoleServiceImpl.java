package com.tianjian.property.web.service.impl;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.dao.DoorDao;
import com.tianjian.property.dao.PropertyDao;
import com.tianjian.property.dao.RolePropertyDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.web.service.SelectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private DoorDao doorDao;
    @Autowired
    private PropertyDao propertyDao;
    @Override
    public List<Integer> selectRole(Integer userId){
        //查询用户的角色
        List<Integer> list = userDao.selectRoleByUserId(userId);
        //查询该角色管理的项目(百为项目id)
        List<Integer> properties = rolePropertyDao.selectPropertyByRoleId(list,"property");
        return properties;
    }
    @Override
    public List<Map> selecProperty(Integer userId){
        //查询用户的角色
        List<Integer> list = userDao.selectRoleByUserId(userId);
        //查询该角色管理的项目(百为项目id)
        List<Integer> properties = rolePropertyDao.selectPropertyByRoleId(list,"property");
        List<Map> doors = propertyDao.selectProperty(properties);
        return doors;
    }
}
