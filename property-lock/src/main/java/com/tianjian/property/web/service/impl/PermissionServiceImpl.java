package com.tianjian.property.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.Role;
import com.tianjian.property.bean.User;
import com.tianjian.property.dao.RoleDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.management.service.impl.HttpService;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Service
public class PermissionServiceImpl extends HttpService implements PermissionService {
    @Value("${baiwei.webLoginURL}")
    private  String webLoginURL;
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
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

    @Override
    public LockResult addStaff(User user) {
        String phone = user.getPhone();
        HashMap<String, Object> map = new HashMap<>();
        map.put("Identity",phone);
       // map.put("Password",Password);
        Map fromJson = (Map) postResult(webLoginURL+"?scenario=Mobile", map);
        Map<String,Object> identity = (Map<String, Object>) fromJson.get("Identity");
        if (identity==null){
            return new LockResult(false,"添加失败,请先注册企业用户", ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
        Integer userId = (Integer) identity.get("UserId");
        user.setUserId(userId);
        int i = userDao.insertSelective(user);
        if (i>0){
            return new LockResult(true,  "添加成功", ErrorEnum.SUCCESS.getCode(), "");
        }else{
            return new LockResult(false,ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
    }

    @Override
    public int deleteStaff(String userId) {
        return userDao.deleteByUserId(userId);
    }

    @Override
    @Transactional
    public int addRole(Role role) {
        return roleDao.insertSelective(role);
    }

    @Override
    @Transactional
    public int updateRole(Role role) {
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteRole(Integer id) {
        Role role = new Role();
        role.setId(id);
        role.setStatus(1);
        return roleDao.updateByPrimaryKeySelective(role);
    }

    @Override
    public PageResult<Role> selectRole(Role role,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roles = roleDao.selectRole(role);
        PageInfo<Role> staffPageInfo = new PageInfo<>(roles);
        List<Role> list = staffPageInfo.getList();
        int pages = staffPageInfo.getPages();
        //总共多少条
        long total = staffPageInfo.getTotal();
        PageResult<Role> PageResult = new PageResult<>(pageSize,pageNum,list,total,pages);
        return PageResult;
    }
}
/*
        rhL1jhNMnhM=
        rhL1jhNMnhM=
                Rv2DQUi+0z4=
                Rv2DQUi+0z4=*/
//9/byy8/mfaIC2RbBYeDZugt+UoEbGbTkihvpM7eioRPRmqUrUkgmUHpmui3y8OLiSc3sSt2ixTUOvtQfCzNhQA==
