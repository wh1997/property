package com.tianjian.property.web.controller;

import com.tianjian.property.bean.User;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public LockResult selectStaff(@RequestHeader String token , Map map) {
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
}
