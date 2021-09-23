package com.tianjian.property.management.service.impl;

import com.google.gson.Gson;
import com.tianjian.property.bean.BaiWeiId;
import com.tianjian.property.management.dao.BaiWeiIdDao;
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
    @Value("${baiwei.url}")
    private String url;
    @Override
    public List getBuildings(Integer parkId) {
        String credentialId="6811833670T5FHF9N";
        String header="BuildingId,ParkId,Term,BuildingNo,Name";
        Map resultMap = HttpClientUtil.BWdoGet(url + "/Buildings/parkId:" + parkId + "?page=0", credentialId, header);
        List result = (List) resultMap.get("result");
        return result;
    }
  //DOTO
    @Override
    public List getApartments(Integer buildingId) {
        String credentialId="6811833670T5FHF9N";
        String header="ApartmentId,BuildingId,ApartmentNo,DoorNo";
        Map resultMap = HttpClientUtil.BWdoGet(url + "/Apartments/buildingId:" + buildingId + "?page=0", credentialId, header);
        List result = (List) resultMap.get("result");
        return result;
    }

    @Override
    public List getProperty() {
        return   baiWeiIdDao.selectAll();
    }
}
