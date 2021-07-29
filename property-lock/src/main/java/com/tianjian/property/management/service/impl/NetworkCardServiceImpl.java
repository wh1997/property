package com.tianjian.property.management.service.impl;

import com.google.gson.Gson;
import com.tianjian.property.management.dao.NetworkCardDao;
import com.tianjian.property.management.service.NetworkCardService;
import com.tianjian.property.utils.HttpClientUtil;
import com.tianjian.property.utils.HttpUtils;
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
public class NetworkCardServiceImpl implements NetworkCardService {
    @Autowired
    private NetworkCardDao networkCardDao;
    @Value("${baiwei.BWLockURL}")
    private  String BWLockURL;
    @Override
    @Transactional
    public void updateStatus(Integer id, Integer status) {
        networkCardDao.updateStatus(id,status);
    }

    @Override
    public List selectEquipment(Integer pid) {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        map.put("Pid",pid.toString());
        String JSON = gson.toJson(map);
        String s = HttpClientUtil.doPostJson(BWLockURL+"/EquipmentQuery.ashx", JSON);
        List list = gson.fromJson(s, List.class);
        return list;
    }
    @Override
    public Map selectEquipmentStatus(String Imei) {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        map.put("imei",Imei);
        String JSON = gson.toJson(map);
        String s = HttpClientUtil.doPostJson(BWLockURL+"/EquipmentStatus.ashx", JSON);
        Map list = gson.fromJson(s, Map.class);
        return list;
    }

    @Override
    public Map openLock(String imei, String userid, String pid) {
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<>();
        map.put("imei",imei);
        map.put("userid",userid);
        map.put("Pid",pid);
        String JSON = gson.toJson(map);
        String s = HttpClientUtil.doPostJson(BWLockURL+"/Open.ashx", JSON);
        Map list = gson.fromJson(s, Map.class);
        return list;
    }
}
