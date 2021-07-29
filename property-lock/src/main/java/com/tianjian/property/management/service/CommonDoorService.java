package com.tianjian.property.management.service;


import com.tianjian.property.bean.Door;

import java.util.List;
import java.util.Map;

public interface CommonDoorService {
    int addCommonDoor(Door door);

    List<Map<String, List<Door>>> selectCommonDoor( Integer propertyid, Integer doortype, Integer pageNum, Integer pageSize);

    List<Door> fuzzyQueryCommonDoor(String doorName,Integer doorType,Integer pageNum,Integer pageSize);

    List<Map> selectDoorType();
}
