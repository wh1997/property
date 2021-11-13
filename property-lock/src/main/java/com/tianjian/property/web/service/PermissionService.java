package com.tianjian.property.web.service;

import com.tianjian.property.bean.User;
import com.tianjian.property.utils.PageResult;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
public interface PermissionService {
    PageResult<User> selectStaff(Integer pageNum, Integer pageSize,User user);
}
