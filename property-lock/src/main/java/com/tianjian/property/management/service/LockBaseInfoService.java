package com.tianjian.property.management.service;

import com.tianjian.property.utils.LockResult;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/6/22
 */
public interface LockBaseInfoService  {
    //修改设备状态
    LockResult updateStatus(String lockId, Integer lock, Integer id, Integer status);
    //管理员开锁
    Map openLock(String lockId, Integer lockUserId, Integer doorId);
}
