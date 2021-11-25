package com.tianjian.property.web.service;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.LockAuthorization;
import com.tianjian.property.bean.LockUser;
import com.tianjian.property.bean.User;
import com.tianjian.property.utils.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
public interface  AuthorizationService {
    PageResult<User> selectUser(Integer pageNum, Integer pageSize, List<Integer> propertyList);

    int addRight(LockAuthorization lockAuthorization);

    PageResult<Door> selectDoorByProperty(List<Integer> propertyList, Integer pageNum, Integer pageSize);

    PageResult<Map<String, Object>> selectRight(Integer userId,Integer pageNum, Integer pageSize);

    int deleteRight(Integer aId);

    int addLockuser(LockUser lockUser);

    int deleteLockuser(Integer id);

    int updateLockuser(LockUser lockUser);

    List<Map> selectLockuser(LockUser lockUser);
}
