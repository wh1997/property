package com.tianjian.property.web.controller;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.LockAuthorization;
import com.tianjian.property.bean.User;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.AuthorizationService;
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
 * @description:   门禁授权
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private SelectRoleService selectRoleService;
    /**
     * @Description: 查看所有住户
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    //TODO  待定  没确定用户的地址
    @RequestMapping("/select/user")
    public LockResult selectUser(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            Integer appUID = TokenUtil.getAppUID(token);
            List<Integer> propertyList = selectRoleService.selectRole(appUID);
            if (propertyList==null){
                return new LockResult(false,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
            }
            PageResult<User> pageResult= authorizationService.selectUser(pageNum,pageSize,propertyList);
            if (pageResult.getRows()!=null){
                return new LockResult(true,  ErrorEnum.SUCCESS.getErrorMsg(), ErrorEnum.SUCCESS.getCode(), pageResult);
            }else {
                return new LockResult(true,  "查询成功没有数据", ErrorEnum.SUCCESS.getCode(), pageResult);
            }

        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 查看所有可授权的门
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/select/door")
    public LockResult selectDoorByProperty(@RequestHeader String token,@RequestBody Map map ) {
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            List<Integer> propertyList = selectRoleService.selectRole(appUID);
            if (propertyList==null){
                return new LockResult(false,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
            }
            PageResult<Door> door= authorizationService.selectDoorByProperty(propertyList,pageNum,pageSize);
            if (door==null){
                return new LockResult(true,  ErrorEnum.SUCCESS.getErrorMsg(), ErrorEnum.SUCCESS.getCode(), door);
            }else {
                return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
            }
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 门锁授权
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/add/right")
    public LockResult addRight(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer appUID = TokenUtil.getAppUID(token);
            LockAuthorization lockAuthorization = BeanChangeUtils.mapToBean(map, LockAuthorization.class);
            lockAuthorization.setAddPerson(appUID);
            int i = authorizationService.addRight(lockAuthorization);
            if (i > 0) {
                return new LockResult(true, "操作成功", ErrorEnum.SUCCESS.getCode(), null);
            } else {
                return new LockResult(false, "操作失败", ErrorEnum.SUCCESS.getCode(), null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new LockResult(false, ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 查看住户的所有门禁权限
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/select/right")
    public LockResult selectRight(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            Integer userId = (Integer) map.get("userId");
            PageResult<Map<String,Object>> resultMap=authorizationService.selectRight(userId,pageNum,pageSize);
            if (resultMap==null){
                return new LockResult(true, "查询成功,请添加开锁权限", ErrorEnum.SUCCESS.getCode(), "");
            }
            return new LockResult(true, "查询成功", ErrorEnum.SUCCESS.getCode(), resultMap);
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
    /**
     * @Description: 删除授权
     * @Param:
     * @return:
     * @Date: 2021/11/8
     */
    @RequestMapping("/delete/right")
    public LockResult deleteRight(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer aId = (Integer) map.get("aId");
            int i =authorizationService.deleteRight(aId);
            if (i>0){
                return new LockResult(true, "操作成功", ErrorEnum.SUCCESS.getCode(), null);
            }else{
                return new LockResult(false, "操作失败", ErrorEnum.SUCCESS.getCode(), null);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,  ErrorEnum.COMMON_ERROR.getErrorMsg(), ErrorEnum.COMMON_ERROR.getCode(), "");
        }
    }
}
