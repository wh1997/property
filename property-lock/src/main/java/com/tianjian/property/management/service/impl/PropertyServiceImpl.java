package com.tianjian.property.management.service.impl;

import com.tianjian.property.dao.BaiWeiIdDao;
import com.tianjian.property.dao.UserDao;
import com.tianjian.property.management.service.PropertyService;
import com.tianjian.property.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/7/2
 */
@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private BaiWeiIdDao baiWeiIdDao;
    @Autowired
    private UserDao userDao;
    @Value("${baiwei.url}")
    private String url;
/*
    //TODO 小程序端直接对接
    @Override
    public List getBuildings(Integer parkId) {
        String credentialId="6811833670T5FHF9N";
        String header="BuildingId,ParkId,Term,BuildingNo,Name";
        Map resultMap = HttpClientUtil.BWdoGet(url + "/Buildings/parkId:" + parkId + "?page=0", credentialId, header);
        List result = (List) resultMap.get("result");
        return result;
    }
  //TODO 小程序端直接对接
    @Override
    public List getApartments(Integer buildingId) {
        String credentialId="6811833670T5FHF9N";
        String header="ApartmentId,BuildingId,ApartmentNo,DoorNo";
        Map resultMap = HttpClientUtil.BWdoGet(url + "/Apartments/buildingId:" + buildingId + "?page=0", credentialId, header);
        List result = (List) resultMap.get("result");
        return result;
    }
*/

    @Override
    public List getProperty(Integer appUID) {
        //根据登录用户id查询角色

        return   baiWeiIdDao.selectByuserId(appUID);
    }
}
