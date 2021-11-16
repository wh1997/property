package com.tianjian.property.web.controller;

import com.tianjian.property.bean.Role;
import com.tianjian.property.bean.User;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @description:  管理员权限
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    /** 
    * @Description: 查询所有用户
    * @Param:  
    * @return:  
    * @Date: 2021/11/13 
    */
    @RequestMapping("/select/staff")
    public LockResult selectStaff(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            User user = BeanChangeUtils.mapToBean(map, User.class);
            PageResult<User> pageResult =permissionService.selectStaff(pageNum,pageSize,user);
            if (pageResult.getRows()!=null){
                return new LockResult(true,  ErrorEnum.SUCCESS.getErrorMsg(), ErrorEnum.SUCCESS.getCode(), pageResult);
            }else {
                return new LockResult(true,  "查询成功没有数据", ErrorEnum.SUCCESS.getCode(), pageResult);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 添加管理员
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/add/staff")
    public LockResult addStaff(@RequestHeader String token ,@RequestBody Map map) {
        try {
            User user = BeanChangeUtils.mapToBean(map, User.class);
            return permissionService.addStaff(user);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 删除管理员(将管理员改成普通用户)
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/delete/staff")
    public LockResult deleteStaff(@RequestHeader String token ,@RequestBody Map map) {
        try {
            String userId = (String) map.get("userId");
            int i= permissionService.deleteStaff(userId);
            if (i>0){
                return new LockResult(true,  "删除成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 添加角色
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/add/role")
    public LockResult addRole(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Role role = BeanChangeUtils.mapToBean(map, Role.class);
            int i= permissionService.addRole(role);
            if (i>0){
                return new LockResult(true,  "添加成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 修改角色
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/update/role")
    public LockResult updateRole(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Role role = BeanChangeUtils.mapToBean(map, Role.class);
            int i= permissionService.updateRole(role);
            if (i>0){
                return new LockResult(true,  "修改成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description: 删除角色
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/delete/role")
    public LockResult deleteRole(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer id = (Integer) map.get("id");
            int i= permissionService.deleteRole(id);
            if (i>0){
                return new LockResult(true,  "删除成功", ErrorEnum.SUCCESS.getCode(), "");
            }else {
                return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }
    /**
    * @Description:  角色列表
    * @Param:
    * @return:
    * @Date: 2021/11/13
    */
    @RequestMapping("/select/role")
    public LockResult selectRole(@RequestHeader String token ,@RequestBody Map map) {
        try {
            Integer pageNum = (Integer) map.get("pageNum");
            Integer pageSize = (Integer) map.get("pageSize");
            Role role = BeanChangeUtils.mapToBean(map, Role.class);
            PageResult<Role> result= permissionService.selectRole(role,pageNum,pageSize);
            return new LockResult(true,  "查询成功", ErrorEnum.SUCCESS.getCode(), result);
        }catch (Exception e){
            e.printStackTrace();
            return new LockResult(false,   ErrorEnum.OPERATION_ERROR.getErrorMsg(), ErrorEnum.OPERATION_ERROR.getCode(), "");
        }
    }

}
