package com.tianjian.property.management.controller;

import com.tianjian.property.bean.LockAuthCode;
import com.tianjian.property.bean.vo.LockBaseInfoVo;
import com.tianjian.property.management.service.EquipmentService;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/** 
* @Description: 设备接口
* @Param:
* @return:  
* @Date: 2021/5/27
*/
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;
    @PostMapping("/add/lock")
    /**
    * @Description:添加蓝牙门锁
    * @Param: [lockBaseInfo 门锁基础信息, hardwareVersion 蓝牙门锁的硬件版本号, softwareVersion 蓝牙门锁的软件版本号,  lockAuthCode 门锁授权码 ]
    * @return: com.tagen.lock.utils.LockResult
    * @Date: 2021/5/30
    */
    public LockResult addLock(@RequestBody Map map, @RequestHeader String token){
        try {
            Map lockInfoBaseMap =  (Map) map.get("lockInfoBase");
            Map lockAuthCodeMap = (Map) map.get("lockAuthCode");
            String hardwareVersion = (String) map.get("hardwareVersion");
            String softwareVersion = (String) map.get("softwareVersion");
            Integer doorid = (Integer) map.get("doorId");
            Integer appUID = TokenUtil.getAppUID(token);
            Map result = equipmentService.addBluetooth(lockInfoBaseMap, lockAuthCodeMap, hardwareVersion, softwareVersion,doorid,appUID.toString());
            Integer resultCode = (Integer) result.get("resultCode");
            String reason = (String) result.get("reason");
            if (resultCode==0){
                return new LockResult(true, ErrorEnum.SUCCESS.getErrorMsg(), ErrorEnum.SUCCESS.getCode(),result);
            }else{
                return new LockResult(false,reason,200,result);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
    @PostMapping("/list")
    
    /** 
    * @Description: 设备列表
    * @Param: [map] 
    * @return: com.tagen.lock.utils.LockResult 
    * @Date: 2021/6/21 
    */
    public LockResult EquipmentList(@RequestBody Map map){
        try {
            //获取设备的类型 1蓝牙锁 2网关  3网卡
            Integer equipmentType = (Integer) map.get("equipmentType");
            //设备所在项目的id
            Integer propertyId = (Integer) map.get("propertyId");
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            List resultList= equipmentService.selectList( equipmentType, propertyId, pageNum, pageSize);
            if(resultList==null || resultList.size()==0){
                return new LockResult(true,"查询成功没有数据",ErrorEnum.SUCCESS.getCode(),null);
            }
            return new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(),ErrorEnum.SUCCESS.getCode(),resultList);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
    /**
    * @Description: 设备详情
    * @Param: [map]
    * @return: com.tagen.lock.utils.LockResult
    * @Date: 2021/6/21
    */
    @PostMapping("/details")
    public LockResult Equipment(@RequestBody Map map){
        try {
            //获取设备的类型 1蓝牙锁 2网关  3网卡
            Integer equipmentType = (Integer) map.get("equipmentType");
            //设备id
            Integer equipmentId = (Integer) map.get("equipmentId");
            Object result= equipmentService.selectEquipment( equipmentType, equipmentId);
            if (result==null){
                return new LockResult(true,"查询成功没有数据",ErrorEnum.SUCCESS.getCode(),result);
            }
            return new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(),ErrorEnum.SUCCESS.getCode(),result);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
    /**
    * @Description: 模糊搜索设备
    * @Param: [map]
    * @return: com.tagen.lock.utils.LockResult
    * @Date: 2021/6/21
    */
    @PostMapping("/fuzzy/search")
    public LockResult fuzzySearch(@RequestBody Map map){
        try {
            //获取设备的类型 1蓝牙锁 2网关  3网卡
            Integer equipmentType = (Integer) map.get("equipmentType");
            //所在项目id
            Integer propertyId = (Integer) map.get("propertyId");
            //搜索关键字
            String KeyWord = (String) map.get("KeyWord");
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            Object result= equipmentService.fuzzySearch( propertyId,equipmentType, KeyWord,pageNum,pageSize);
            if (result==null){
                return new LockResult(true,"查询成功没有数据",ErrorEnum.SUCCESS.getCode(),result);
            }
            return new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(),ErrorEnum.SUCCESS.getCode(),result);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }

}
