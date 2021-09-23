package com.tianjian.property.management.service.impl;

import com.tianjian.property.bean.Door;
import com.tianjian.property.management.dao.DoorDao;
import com.tianjian.property.management.dao.LockBaseInfoDao;
import com.tianjian.property.management.dao.LockDao;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.management.service.LockBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/6/22
 */
@Service
public class LockBaseInfoServiceImpl implements LockBaseInfoService {
    @Autowired
    public LockBaseInfoDao lockBaseInfoDao;
    @Autowired
    public LockDao lockDao;
    @Autowired
    public DoorDao doorDao;
    @Autowired
    public GatewayService gatewayService;
    @Value("${apartment.theRemoteUnlock}")
    private  String theRemoteUnlock;
    @Override
    @Transactional
    public void updateStatus(String lockId,Integer lock,Integer id, Integer status) {
        //先删除蓝牙门锁绑定的网关
        gatewayService.LockUnBindingGateway(lockId,lock,id);
        //修改蓝牙门锁的转态为废弃(删除)
        lockBaseInfoDao.updateStatus(id,status);
    }

    @Override
    public Map openLock(String lockId, Integer lockUserId, Integer doorID) {
      Door door= doorDao.selectById(doorID);
        Integer doortype = door.getDoorType();
        if(doortype!=0){
            HashMap<String, Object> datamap = new HashMap<>();
            //是	string 门锁id
            datamap.put("lockId",lockId);
            //是	int 门锁用户ID （操作开锁的门锁用户ID，开锁日志上报时，根据该值，可以知道是哪个门锁用户进行开锁操作详情见附录字段说明）
            //900	超级管理员（一般分配给门锁所有者）
            //901~2000	普通管理员
            //2001~49999	普通用户
            //50000~52000	普通用户（人脸识别）
            datamap.put("lockUserId",lockUserId);
            //开锁
            Map result = gatewayService.bindinggateway(theRemoteUnlock,datamap);
            return result;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("resultCode",500);
        map.put("reason","房间有人请勿开锁");
        return map;
    }
}
