package com.tianjian.property.management.controller;

import com.tianjian.property.management.service.LockBaseInfoService;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.error.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:蓝牙门锁接口
 * @author: ManolinCoder
 * @time: 2021/6/22
 */
@RestController
@RequestMapping("/LockBaseInfo")
public class LockBaseInfoController {
    @Autowired
    public LockBaseInfoService lockBaseInfoService;
    @PostMapping("/update/baseinfo")
    
    /** 
    * @Description: 删除蓝牙门锁
    * @Param: [map] 
    * @return: com.tagen.lock.utils.LockResult 
    * @Date: 2021/6/22 
    */
    public LockResult updateStatus(@RequestBody Map map){
            //门锁设备id
            Integer id = (Integer) map.get("id");
            //要修改的状态
            Integer status= (Integer) map.get("status");
            //锁id
            Integer lock= (Integer) map.get("lock");
            //门锁id(厂家生成的id)
            String lockId= (String) map.get("lockId");
            return lockBaseInfoService.updateStatus(lockId, lock, id, status);
    }
    @PostMapping("/open/lock")
    
    /** 
    * @Description: 管理员开锁 
    * @Param: [map] 
    * @return: com.tagen.lock.utils.LockResult 
    * @Date: 2021/6/23 
    */
    public LockResult openLock(@RequestBody Map map){
        try {
            //门锁id(厂家生成的id)
            String lockId = (String) map.get("lockId");
            //门锁用户ID
            Integer lockUserId= (Integer) map.get("lockUserId");
            //门id
            Integer doorId= (Integer) map.get("doorId");
            Map resultMap = lockBaseInfoService.openLock(lockId, lockUserId, doorId);
            if ((Integer) resultMap.get("resultCode")==0){
                return   new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(),ErrorEnum.SUCCESS.getCode(),null);
            }
             return new LockResult(false,(String) resultMap.get("reason"),(Integer) resultMap.get("resultCode"),null);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
}
