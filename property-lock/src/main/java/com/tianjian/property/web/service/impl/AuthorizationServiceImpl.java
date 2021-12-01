package com.tianjian.property.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.LockAuthorization;
import com.tianjian.property.bean.LockUser;
import com.tianjian.property.bean.User;
import com.tianjian.property.dao.DoorDao;
import com.tianjian.property.dao.LockAuthorizationDao;
import com.tianjian.property.dao.LockUserDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.utils.DateUtils;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.web.service.AuthorizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Service
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private DoorDao doorDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LockAuthorizationDao lockAuthorizationDao;
    @Autowired
    private LockUserDao lockUserDao;
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
    public PageResult<Door> selectDoorByProperty(List<Integer> propertyList,Door door, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Door> doors = doorDao.selectDoorByProperty(propertyList,door);
        PageInfo<Door> doorVoPageInfo = new PageInfo<>(doors);
        List<Door> Doorlist = doorVoPageInfo.getList();
        int pages = doorVoPageInfo.getPages();
        //总共多少条
        long total = doorVoPageInfo.getTotal();
        PageResult<Door> PageResult = new PageResult<>(pageSize,pageNum,Doorlist,total,pages);
        return  PageResult;
    }

    @Override
    public PageResult<Map<String, Object>> selectRight(Integer userId, Integer pageNum, Integer pageSize) throws Exception {
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
    public PageResult<Map<String, Object>> ordinarySelectRight(Integer userId, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> maps = userDao.ordinarySelectRight(userId);
        PageInfo<Map<String, Object>> rightPageInfo = new PageInfo<>(maps);
        List<Map<String, Object>> Doorlist = rightPageInfo.getList();
        int pages = rightPageInfo.getPages();
        //总共多少条
        long total = rightPageInfo.getTotal();
        PageResult<Map<String, Object>> PageResult = new PageResult<>(pageSize,pageNum,Doorlist,total,pages);
        return PageResult;
    }
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int addRight(LockAuthorization lockAuthorization) {
        Integer doorId = lockAuthorization.getDoorId();
        //将房间状态改为在住
        doorDao.updateDoorStatus(doorId,0);
        return lockAuthorizationDao.insertSelective(lockAuthorization);
    }
    @Override
    @Transactional
    public int deleteRight(Integer aId) {
        return lockAuthorizationDao.updateStatus(aId);
    }

    @Override
    @Transactional
    public int addLockuser(LockUser lockUser) {
        List<LockUser> select = lockUserDao.selectRepetition(lockUser);
        if (select.size()>0){
            return -1 ;
        }else {
            return lockUserDao.insertSelective(lockUser) ;
        }
    }

    @Override
    @Transactional
    public int deleteLockuser(Integer userId,Integer doorId,Integer appUID) {
        LockUser lockUser = new LockUser();
        lockUser.setDoorId(doorId);
        lockUser.setUserId(userId);
        List<LockUser> lockUsers = lockUserDao.selectRepetition(lockUser);
        LockUser lockUser1 = lockUsers.get(0);
        Integer lockUserId = lockUser1.getLockUserId();
        System.out.println(lockUser1);
        System.out.println(lockUserId);
        if (lockUserId!=900){
            lockUser.setAddPerson(appUID);
            return lockUserDao.deleteLockuser(lockUser);
        }else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int updateLockuser(LockUser lockUser) {
        return lockUserDao.updateByPrimaryKeySelective(lockUser);
    }

    @Override
    public List<Map> selectLockuser(LockUser lockUser) {
        return lockUserDao.lockUserDao(lockUser);
    }
}
