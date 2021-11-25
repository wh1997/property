package com.tianjian.property.management.controller;

import com.tianjian.property.bean.LockLog;
import com.tianjian.property.bean.Module;
import com.tianjian.property.management.service.OpenLockService;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description:   开锁
 * @author: ManolinCoder
 * @time: 2021/11/24
 */
@RestController
@RequestMapping("/open")
public class OpenLockController {
    @Autowired
    private OpenLockService openLockService;



    /**
     * @Description: 开锁
     * @Param: [map]
     * @return: com.tagen.lock.utils.LockResult
     * @Date: 2021/6/23
     */
    @PostMapping("/user/lock")
    public LockResult openLock(@RequestHeader String token, @RequestBody Map map){
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            //门锁id(厂家生成的id)
            Integer doorId = (Integer) map.get("doorId");
            //门锁用户ID
            Integer lockUserId= (Integer) map.get("lockUserId");
            return openLockService.openLock(appUID,doorId, lockUserId);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
    /**
     * @Description: 获取开锁记录
     * @Param: [map]
     * @return: com.tagen.lock.utils.LockResult
     * @Date: 2021/6/23
     */
    @PostMapping("/user/lock/log")
    public LockResult openLockLog(@RequestHeader String token, @RequestBody Map map){
        try {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            LockLog lockLog = BeanChangeUtils.mapToBean(map, LockLog.class);
            PageResult<LockLog> result=openLockService.openLockLog(lockLog,pageNum,pageSize);
            if (result.getRows()!=null){
                return new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(),ErrorEnum.SUCCESS.getCode(),result);
            }else {
                return new LockResult(true,"没有开门数据",ErrorEnum.SUCCESS.getCode(),"");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
}
