package com.tianjian.property.web.controller;

import com.google.inject.internal.cglib.core.$ClassEmitter;
import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.Gateway;
import com.tianjian.property.bean.LockBaseInfo;
import com.tianjian.property.bean.vo.Param;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.ManageService;
import com.tianjian.property.web.service.SelectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description:  设备管理
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@RestController
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ManageService manageService;
    @Autowired
    private SelectRoleService selectRoleService;
    @Autowired
    private GatewayService gatewayService;
    /**
    * @Description: 删除蓝牙门锁
    * @Param:  
    * @return:  
    * @Date: 2021/11/8 
    */
    @RequestMapping("/bluetooth/delete")
    public LockResult deleteBluetooth(@RequestHeader String token ,@RequestBody Map map)  {
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
    public LockResult updataBluetooth(@RequestHeader String token ,@RequestBody Map map) throws Exception {
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
    public LockResult selectBluetooth(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            List<Integer> propertyList = selectRoleService.selectRole(appUID);
            if (propertyList==null){
                return new LockResult(false,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
            }
            LockBaseInfo lockBaseInfo = BeanChangeUtils.mapToBean(map, LockBaseInfo.class);
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
    * @Description: 查看蓝牙锁详情
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/bluetooth/details")
    public LockResult bluetoothdDetails(@RequestHeader String token ,@RequestBody Map map) {
        String lockId= (String) map.get("lockId");
        Map details = manageService.BluetoothdDetails(lockId);
        Integer resultCode = (Integer) details.get("resultCode");
        String reason = (String) details.get("reason");
        if (resultCode==0){
            return new LockResult(true,"查询成功",ErrorEnum.SUCCESS.getCode(),details);
        }else{
            return new LockResult(false,reason,ErrorEnum.OPERATION_ERROR.getCode(),"");
        }
    }
    /**
    * @Description: 查看蓝牙锁绑定网关详情
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/lock/gateway/details")
    public LockResult lockGatewayDetails(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer lockId= (Integer) map.get("lockId");
            Map details = manageService.lockGatewayDetails(lockId);
            return new LockResult(true,"查询成功",ErrorEnum.SUCCESS.getCode(),details);
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false, ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 设置蓝牙门锁
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/lock/configuration")
    public LockResult configuration(@RequestHeader String token ,@RequestBody Map map) {
        try {
            LockResult result = manageService.configuration(map);
            return result;
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }

    }
    /**
    * @Description: 查看网关信息
    * @Param:
    * @return:
    * @Date: 2021/11/8
    */
    @RequestMapping("/gateway/select")
    public LockResult selectGateway(@RequestHeader String token ,@RequestBody Map map) throws Exception {
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
    /**
     * @Description: 编辑网关
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/gateway/update")
    public LockResult updateGateway(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Gateway gateway = BeanChangeUtils.mapToBean(map, Gateway.class);
            int i = manageService.updateGateway(gateway);
            if (i>0){
                return new LockResult(true,  "修改成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,  "修改失败", ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 删除网关
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/gateway/delete")
    public LockResult deleteGateway(@RequestHeader String token ,@RequestBody Map map) {
        try {
            String gatewayId = (String) map.get("gatewayId");
            int resultMap=gatewayService.deleteGateway(gatewayId);
            if (resultMap>0){
                return new LockResult(true,  "删除成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,  "删除失败", ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 网关详情
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/gateway/details")
    public LockResult gatewayDetails(@RequestHeader String token ,@RequestBody Map map) {
        try {
            String gatewayId = (String) map.get("gatewayId");
            Map resultMap=manageService.gatewayDetails(gatewayId);
            if (resultMap!=null){
                return new LockResult(true,ErrorEnum.SUCCESS.getErrorMsg(), ErrorEnum.SUCCESS.getCode(), resultMap);
            }else {
                return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
}
