package com.tianjian.property.management.service;


import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.utils.PageResult;

import java.util.List;
import java.util.Map;

public interface RoomDoorService {
    PageResult<DoorVo> selsctAll(Integer propertyid, Integer pageNum, Integer pageSize) ;
    Map<String, List<DoorVo>> selsctRoomnoAndPropertyname(Integer propertyid,String roomno,Integer pageNum,Integer pageSize);
    Map<String, List<DoorVo>> screenRoomDoor(Integer propertyid,Integer bulidingid ,String unitname,Integer pageNum,Integer pageSize);
    Map<String,String> selectdoorparticulars(Integer doorid);
    //模糊搜索
    List<Door> fuzzySearch(Integer propertyid, String fuzzy, Integer pageNum, Integer pageSize);

    Map addDoor(List<Map> door, Integer appUID) throws Exception;
}
