package com.tianjian.property.web.controller;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.utils.BeanChangeUtils;
import com.tianjian.property.utils.LockResult;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.utils.TokenUtil;
import com.tianjian.property.utils.error.ErrorEnum;
import com.tianjian.property.web.service.MonitorService;
import com.tianjian.property.web.service.SelectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * @description:    门禁监控
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {
    @Autowired
    private MonitorService monitorServices;
    @Autowired
    private SelectRoleService selectRoleService;

    @RequestMapping("/select/door")
    public LockResult selectDoor(@RequestHeader String token , Map map) throws Exception {
        Integer appUID = TokenUtil.getAppUID(token);
        List<Integer> list = selectRoleService.selectRole(appUID);
        if (list==null){
            return new LockResult(true,"没有权限,请添加权限", ErrorEnum.RIGHT.getCode(), "");
        }
        Door door = BeanChangeUtils.mapToBean(map, Door.class);
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        PageResult<DoorVo> doors = monitorServices.selsctAll(door,list, pageNum, pageSize);
        if (doors==null){
            return new LockResult(true,"获取成功,没有数据", ErrorEnum.SUCCESS.getCode(), "");
        }else {
            return new LockResult(true,"获取成功",ErrorEnum.SUCCESS.getCode(),doors);
        }
    }
    @RequestMapping("/update/door")
    public LockResult updateDoor(@RequestHeader String token , Map map) {
        return new LockResult(true,"获取成功",ErrorEnum.SUCCESS.getCode(),"");
    }
}
