package com.tianjian.property.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.LockLog;
import com.tianjian.property.bean.Module;
import com.tianjian.property.dao.DoorDao;
import com.tianjian.property.dao.LockLogDao;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.management.service.OpenLockService;
import com.tianjian.property.utils.DateUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.error.BusinessException;
import com.tianjian.property.utils.error.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/24
 */
@Service
@Slf4j
public class OpenLockServiceImpl implements OpenLockService {
    @Autowired
    private GatewayService gatewayService;
    @Autowired
    private DoorDao doorDao;
    @Autowired
    private LockLogDao lockLogDao;
    @Value("${apartment.theRemoteUnlock}")
    private  String theRemoteUnlock;


    @Override
    @Transactional
    public LockResult openLock(Integer userId, Integer doorId, Integer lockUserId) throws ParseException, BusinessException {
        List<Map> selectlock = doorDao.selectlock(doorId);
        if (selectlock.size()==0){
            return new LockResult(false, "开门失败,请先绑定门锁",ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
        Map map = selectlock.get(0);
        Integer id = (Integer) map.get("id");
        Integer propertyId = (Integer) map.get("propertyId");
        Integer doorType = (Integer) map.get("doorType");
        String lockMac = (String) map.get("lockMac");
        String lockId = (String) map.get("lockId");
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
        Integer resultCode = (Integer) result.get("resultCode");
        String reason = (String) result.get("reason");
        Date date = new Date();
        String s = DateUtils.dateToString(date);
        LockLog lockLog = new LockLog();
        lockLog.setDoorId(id);
        lockLog.setLockType(doorType);
        lockLog.setLockMac(lockMac);
        lockLog.setRecordTime(s);
        lockLog.setPropertyId(propertyId);
        lockLog.setUserId(userId);
        lockLog.setAddTime(s);
        if (resultCode==0){
            lockLog.setStatus(0);
            int i = lockLogDao.insertSelective(lockLog);
            if (i<=0){
                log.warn("开锁数据添加失败数据为: "+lockLog.toString());
            }
            return new LockResult(true, "开门成功",ErrorEnum.SUCCESS.getCode(),"");
        }else {
            lockLog.setStatus(1);
            lockLogDao.insertSelective(lockLog);
            return new LockResult(false, reason,ErrorEnum.SYSTEM_ERROR.getCode(),"");
        }
        }

    @Override
    public PageResult<Map> openLockLog(LockLog lockLog,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map> rows = lockLogDao.openLockLog(lockLog);
        PageInfo<Map> staffPageInfo = new PageInfo<>(rows);
        List<Map> row = staffPageInfo.getList();
        int pages = staffPageInfo.getPages();
        //总共多少条
        long total = staffPageInfo.getTotal();
        PageResult<Map> PageResult = new PageResult<>(pageSize,pageNum,row,total,pages);
        return PageResult;
    }
}
