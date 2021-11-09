package com.tianjian.property.web.controller;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.Gateway;
import com.tianjian.property.bean.LockBaseInfo;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.ManageService;
import com.tianjian.property.web.service.SelectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @description:  设备管理
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private SelectRoleService selectRoleService;
    /**
    * @Description: 删除蓝牙门锁
    * @Param:  
    * @return:  
    * @Date: 2021/11/8 
    */
    @RequestMapping("/bluetooth/delete")
    public LockResult deleteBluetooth(@RequestHeader String token , Map map)  {
        Integer id = (Integer) map.get("id");
        int i=  manageService.deleteBluetooth(id);
        if (i>0){
            return new LockResult(true,"删除成功", ErrorEnum.SUCCESS.getCode(), "");
        }
        return new LockResult(false,"删除失败", ErrorEnum.OPERATION_ERROR.getCode(), "");
    }
    /**
    * @Description: 修改蓝牙门锁
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/bluetooth/updata")
    public LockResult updataBluetooth(@RequestHeader String token , Map map) throws Exception {
        LockBaseInfo lockBaseInfo = BeanChangeUtils.mapToBean(map, LockBaseInfo.class);
        int i = manageService.updataBluetooth(lockBaseInfo);
        if (i>0){
            return new LockResult(true,"修改成功", ErrorEnum.SUCCESS.getCode(), "");
        }
        return new LockResult(false,"修改失败", ErrorEnum.OPERATION_ERROR.getCode(), "");
    }
    /**
    * @Description: 查看蓝牙门锁信息
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/bluetooth/select")
    public LockResult selectBluetooth(@RequestHeader String token , Map map) {
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            List<Integer> propertyList = selectRoleService.selectRole(appUID);
            if (propertyList==null){
                return new LockResult(false,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
            }
            LockBaseInfo lockBaseInfo = BeanChangeUtils.mapToBean(map, LockBaseInfo.class);
            //获取设备的类型 1蓝牙锁 2网关  3网卡
            String doorName = (String) map.get("doorName");
            //设备所在项目的id
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            PageResult result= manageService.selectBluetooth(doorName,propertyList,lockBaseInfo,pageNum,pageSize);
            if (result==null){
                return new LockResult(true,"查询成功没有数据",ErrorEnum.SUCCESS.getCode(),result);
            }
            return new LockResult(true,"查询成功",ErrorEnum.SUCCESS.getCode(),result);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
    /**
    * @Description: 查看蓝牙门锁信息
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/bluetooth/details")
    public LockResult BluetoothdDtails(@RequestHeader String token , Map map) {
        String lockId= (String) map.get("lockId");
        Object details = manageService.BluetoothdDetails(lockId);
        return null;
    }
    /**
    * @Description: 查看网关信息
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/Gateway/select")
    public LockResult selectGateway(@RequestHeader String token , Map map) throws Exception {
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            List<Integer> propertyList = selectRoleService.selectRole(appUID);
            if (propertyList==null){
                return new LockResult(false,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
            }
            Gateway gateway = BeanChangeUtils.mapToBean(map, Gateway.class);
            //设备所在项目的id
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            PageResult result= manageService.selectGateway(propertyList,gateway,pageNum,pageSize);
            if (result==null){
                return new LockResult(true,"查询成功没有数据",ErrorEnum.SUCCESS.getCode(),result);
            }
            return new LockResult(true,"查询成功",ErrorEnum.SUCCESS.getCode(),result);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,ErrorEnum.SYSTEM_ERROR.getErrorMsg(),ErrorEnum.SYSTEM_ERROR.getCode(),null);
        }
    }
}
