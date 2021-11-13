package com.tianjian.property.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.User;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.web.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private UserDao userDao;
    @Override
    public PageResult<User> selectStaff(Integer pageNum, Integer pageSize,User user) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> staff = userDao.selectStaff(user);
        PageInfo<User> staffPageInfo = new PageInfo<>(staff);
        List<User> Doorlist = staffPageInfo.getList();
        int pages = staffPageInfo.getPages();
        //总共多少条
        long total = staffPageInfo.getTotal();
        PageResult<User> PageResult = new PageResult<>(pageSize,pageNum,Doorlist,total,pages);
        return PageResult;
    }
}
