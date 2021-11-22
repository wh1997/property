package com.tianjian.property.web.service;

import com.tianjian.property.bean.vo.DoorVo;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
public interface SelectRoleService {
    List<Integer> selectRole(Integer userId);

    List<Map> selecProperty(Integer appUID,Integer status);
}
