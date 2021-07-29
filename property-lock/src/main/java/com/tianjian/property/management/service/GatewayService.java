package com.tianjian.property.management.service;


import com.tianjian.property.bean.Lock;

import java.util.List;
import java.util.Map;

public interface GatewayService {
    //获取token
    String getApartment();
    //接口公共类
    Map  bindinggateway (String method, Map<String,Object> data);
    //绑定网关
    Map gatewayBind(Integer project,String gatewaySeq) throws InterruptedException;
    //门锁绑定网关
    Map LockBindingGateway(String lockId, String gatewayId, Integer doorID, Integer gateway, Integer lock);
    //解除门锁绑定网关
    Map LockUnBindingGateway(String lockId, Integer lock, Integer bluetoothLockId);
    //修改蓝牙网关的设备状态
    List<Lock> updateStatus(Integer id, Integer status);
}
