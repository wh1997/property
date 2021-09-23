package com.tianjian.property.management.service.impl;

import com.google.gson.Gson;
import com.tianjian.property.management.dao.BaiWeiIdDao;
import com.tianjian.property.management.dao.NetworkCardDao;
import com.tianjian.property.management.service.NetworkCardService;
import com.tianjian.property.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/6/22
 */
@Service
public class NetworkCardServiceImpl extends CardHttpService implements NetworkCardService {
    @Autowired
    private NetworkCardDao networkCardDao;
    @Autowired
    private BaiWeiIdDao baiWeiIdDao;
    @Value("${baiwei.BWLockURL}")
    private  String BWLockURL;
    @Override
    @Transactional
    public void updateStatus(Integer id, Integer status) {
        networkCardDao.updateStatus(id,status);
    }

    @Override
    public List selectEquipment(Integer pid) {
       Integer oldId= baiWeiIdDao.selectByPropertyId(pid);
        HashMap<String, String> map = new HashMap<>();
        map.put("Pid",oldId.toString());
        List resultMap = (List) postResult(BWLockURL + "/EquipmentQuery.ashx", map);
        return resultMap;
    }
    @Override
    public Map selectEquipmentStatus(String Imei) {
        HashMap<String, String> map = new HashMap<>();
        map.put("imei",Imei);
        Map resultMap = (Map) postResult(BWLockURL+"/EquipmentStatus.ashx", map);
        return resultMap;
    }

    @Override
    public Map openLock(String imei, String userid, String pid) {
        Integer oldId= baiWeiIdDao.selectByPropertyId(Integer.valueOf(pid));
        HashMap<String, String> map = new HashMap<>();
        map.put("imei",imei);
        map.put("userid",userid);
        map.put("Pid",oldId.toString());
        Map resultMap = (Map) postResult(BWLockURL+"/EquipmentStatus.ashx", map);
        return resultMap;
    }
}
