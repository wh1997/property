package com.tianjian.property.management.service;

import com.tianjian.property.bean.LockLog;
import com.tianjian.property.bean.vo.LockLogVo;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.error.BusinessException;

import java.text.ParseException;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/24
 */
public interface OpenLockService {
    LockResult openLock(Integer userId, Integer lockId, Integer lockUserId) throws ParseException, BusinessException;

    PageResult<LockLogVo> openLockLog(LockLog lockLog, Integer pageNum, Integer pageSize);
}
