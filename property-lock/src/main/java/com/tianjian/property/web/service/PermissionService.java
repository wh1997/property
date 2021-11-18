package com.tianjian.property.web.service;

import com.tianjian.property.bean.Role;
import com.tianjian.property.bean.User;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
public interface PermissionService {
    PageResult<Map> selectStaff(Integer pageNum, Integer pageSize, User user);

    LockResult addStaff(User user);

    int deleteStaff(Integer userId);

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRole(Integer id);

    PageResult<Role> selectRole(Role role,Integer pageNum, Integer pageSize);
}
