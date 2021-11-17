package com.tianjian.property.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.LockAuthorization;
import com.tianjian.property.bean.User;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.dao.DoorDao;
import com.tianjian.property.dao.LockAuthorizationDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.web.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private DoorDao doorDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LockAuthorizationDao lockAuthorizationDao;
    @Override
    public PageResult<User> selectUser(Integer pageNum, Integer pageSize, List<Integer> propertyList) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> user = userDao.selectUser(propertyList);
        PageInfo<User> userPageInfo = new PageInfo<>(user);
        List<User> userList = userPageInfo.getList();
        int pages = userPageInfo.getPages();
        //总共多少条
        long total = userPageInfo.getTotal();
        PageResult<User> PageResult = new PageResult<>(pageSize,pageNum,userList,total,pages);
        return PageResult;
    }
    @Override
    public PageResult<Door> selectDoorByProperty(List<Integer> propertyList, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Door> doors = doorDao.selectDoorByProperty(propertyList);
        PageInfo<Door> doorVoPageInfo = new PageInfo<>(doors);
        List<Door> Doorlist = doorVoPageInfo.getList();
        int pages = doorVoPageInfo.getPages();
        //总共多少条
        long total = doorVoPageInfo.getTotal();
        PageResult<Door> PageResult = new PageResult<>(pageSize,pageNum,Doorlist,total,pages);
        return  PageResult;
    }

    @Override
    public PageResult<Map<String, Object>> selectRight(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> maps = userDao.selectRight(userId);
        PageInfo<Map<String, Object>> rightPageInfo = new PageInfo<>(maps);
        List<Map<String, Object>> Doorlist = rightPageInfo.getList();
        int pages = rightPageInfo.getPages();
        //总共多少条
        long total = rightPageInfo.getTotal();
        PageResult<Map<String, Object>> PageResult = new PageResult<>(pageSize,pageNum,Doorlist,total,pages);
        return PageResult;
    }
    @Override
    @Transactional
    public int addRight(LockAuthorization lockAuthorization) {
        return lockAuthorizationDao.insertSelective(lockAuthorization);
    }
    @Override
    @Transactional
    public int deleteRight(Integer aId) {
        return lockAuthorizationDao.updateStatus(aId);
    }
}
