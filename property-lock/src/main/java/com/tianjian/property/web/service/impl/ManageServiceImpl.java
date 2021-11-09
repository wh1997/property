package com.tianjian.property.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.Gateway;
import com.tianjian.property.bean.LockBaseInfo;
import com.tianjian.property.bean.NetworkCard;
import com.tianjian.property.dao.GatewayDao;
import com.tianjian.property.dao.LockBaseInfoDao;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.utils.PageResult;
import com.tianjian.property.web.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/11/4
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Value("${apartment.BluetoothdDetails}")
    private  String bluetoothdDetails;
    @Autowired
    private LockBaseInfoDao lockBaseInfoDao;
    @Autowired
    private GatewayDao gatewayDao;
    @Autowired
    private GatewayService gatewayService;

    @Override
    public int deleteBluetooth(Integer id) {
        return lockBaseInfoDao.updateStatus(id,2);
    }

    @Override
    public int updataBluetooth(LockBaseInfo lockBaseInfo) {
        return lockBaseInfoDao.updateByPrimaryKeySelective(lockBaseInfo);
    }

    @Override
    public PageResult selectBluetooth(String doorName, List<Integer> propertyList, LockBaseInfo lockBaseInfo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<LinkedHashMap<String, Object>> list= lockBaseInfoDao.selectBluetooth(propertyList,lockBaseInfo,doorName);
        PageInfo<LinkedHashMap<String, Object>> pageInfo=new PageInfo<>(list);
        List<LinkedHashMap<String, Object>> pageList = pageInfo.getList();
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        PageResult<LinkedHashMap<String, Object>> pageResult = new PageResult<LinkedHashMap<String, Object>>(pageSize,pageNum,pageList,total,pages);
        return pageResult;
    }

    @Override
    public Object BluetoothdDetails(String lockId) {
        HashMap<String, Object> datamap = new HashMap<>();
        //	是	string 门锁id
        datamap.put("lockId",lockId);
        //TODO 用户开锁ID   待定
        datamap.put("delLockUserId",901);
        //发送请求
        Map bindinggateway = gatewayService.bindinggateway(bluetoothdDetails, datamap);
        System.out.println(bindinggateway);
        return bindinggateway;
    }

    @Override
    public PageResult selectGateway(List<Integer> propertyList, Gateway gateway, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Gateway> list=  gatewayDao.selectGateway(propertyList,gateway);
        PageInfo<Gateway> pageInfo=new PageInfo<>(list);
        List<Gateway> pageList = pageInfo.getList();
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
        PageResult<Gateway> pageResult = new PageResult<Gateway>(pageSize,pageNum,pageList,total,pages);
        return pageResult;
    }
}
