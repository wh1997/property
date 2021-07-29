package com.tianjian.property.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.*;
import com.tianjian.property.bean.vo.LockBaseInfoVo;
import com.tianjian.property.management.dao.GatewayDao;
import com.tianjian.property.management.dao.LockBaseInfoDao;
import com.tianjian.property.management.dao.LockDao;
import com.tianjian.property.management.dao.NetworkCardDao;
import com.tianjian.property.management.service.EquipmentService;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.utils.BeanChangeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {
@Autowired
private GatewayService gatewayService;
@Autowired
private GatewayDao gatewayDao;
@Autowired
private LockBaseInfoDao lockBaseInfoDao;
@Autowired
private NetworkCardDao NetworkCardDao;
@Autowired
private LockDao lockDao;
@Value("${apartment.addBluetooth}")
private String  addBluetooth;
    @Override
    @Transactional
    public Map addBluetooth(Map lockBaseInfo, Map lockAuthCode, String hardwareVersion, String softwareVersion, Integer doorid, String addpeople) throws Exception {
        HashMap<String, Object> datamap = new HashMap<>();
        //是	LockBaseInfoVo 门锁基础信息
        datamap.put("lockInfoBase",lockBaseInfo);
        //是	LockAuthCode 门锁授权码
        datamap.put("lockAuthCode",lockAuthCode);
        //是	string 蓝牙模块的硬件版本号，可以通过小程序插件、APP的SDK添加门锁时获取到
        datamap.put("hardwareVersion",hardwareVersion);
        //是	string 蓝牙模块的软件版本号 ,可以通过小程序插件、APP的SDK添加门锁时获取到
        datamap.put("softwareVersion",softwareVersion);
        Map result = gatewayService.bindinggateway(addBluetooth, datamap);
        System.out.println(result);
        Integer resultCode = (Integer) result.get("resultCode");
        Map data = (Map) result.get("data");
        //门锁id
        String lockId = (String) data.get("lockId");
        if (resultCode==0){
             LockBaseInfoVo lockInfoBase = BeanChangeUtils.mapToBean(lockBaseInfo, LockBaseInfoVo.class);
            // LockAuthCode lockAuthCodeBean = BeanChangeUtils.mapToBean(lockAuthCode, LockAuthCode.class);
            //请求成功了往门锁基本信息表里添加门锁基本信息
            LockBaseInfo LockBaseInfo = new LockBaseInfo(null,lockId, lockInfoBase.getLockTag(), lockInfoBase.getLockMac(), hardwareVersion, softwareVersion, lockInfoBase.getLockType(),
                    lockInfoBase.getInitStatus(), lockInfoBase.getMaxVolume(), lockInfoBase.getMaxUser(), lockInfoBase.getBleProtocolVer(), lockInfoBase.getRfModuleType(),
                    lockInfoBase.getRfModuleMac(),  null, null,  addpeople, "慧享佳", 1, null);
            lockBaseInfoDao.inster(LockBaseInfo);
            //往锁表里添加基本信息
            Lock lock = new Lock(null, doorid, 0, LockBaseInfo.getId(), null, 0, null, null, null);
            lockDao.inster(lock);
            return result;
        }else{
            return result;
        }
    }

    @Override
    public List selectList(Integer equipmentType, Integer propertyId,Integer pageNum,Integer pageSize) {
        //1蓝牙锁设备基本信息  2  网关基本信息   3  网卡基本信息
        if (equipmentType==1){
            PageHelper.startPage(pageNum,pageSize);
            List<LinkedHashMap<String, Object>> list= lockBaseInfoDao.selectByPropertyId(propertyId);
            PageInfo<LinkedHashMap<String, Object>> pageInfo=new PageInfo<>(list);
            List<LinkedHashMap<String, Object>> pageList = pageInfo.getList();
            return pageList;
        }else if (equipmentType==2){
            //查询网关
            PageHelper.startPage(pageNum,pageSize);
            List<Gateway> list=  gatewayDao.findByPropertyId(propertyId);
            PageInfo<Gateway> pageInfo=new PageInfo<>(list);
            List<Gateway> pageList = pageInfo.getList();
            return pageList;
        }else{
            //查询网卡
            PageHelper.startPage(pageNum,pageSize);
            List<NetworkCard> list =NetworkCardDao.findByPropertyId(propertyId);
            PageInfo<NetworkCard> pageInfo=new PageInfo<>(list);
            List<NetworkCard> pageList = pageInfo.getList();
            return pageList;
        }
    }

    @Override
    public Object selectEquipment(Integer equipmentType, Integer equipmentId) {
        //1蓝牙锁设备基本信息  2  网关基本信息   3  网卡基本信息
        if (equipmentType==1){
            LockBaseInfo list= lockBaseInfoDao.selectById(equipmentId);
            return list;
        }else if (equipmentType==2){
            //查询网关
            Gateway list=  gatewayDao.selectById(equipmentId);
            return list;
        }else{
            //查询网卡
            NetworkCard list =NetworkCardDao.selectByIdAll(equipmentId);
            return list;
        }
    }

    @Override
    public Object fuzzySearch(Integer propertyId,Integer equipmentType, String KeyWord,Integer pageNum,Integer pageSize) {
        String KeyWords= "%"+KeyWord+"%";
        //1蓝牙锁设备基本信息  2  网关基本信息   3  网卡基本信息
        if (equipmentType == 1) {
            PageHelper.startPage(pageNum,pageSize);
            List<LinkedHashMap<String, Object>> list = lockBaseInfoDao.fuzzySearch(propertyId,KeyWords);
            PageInfo<LinkedHashMap<String, Object>> pageInfo=new PageInfo<>(list);
            List<LinkedHashMap<String, Object>> listResult = pageInfo.getList();
            return listResult;
        } else if (equipmentType == 2) {
            //查询网关
            PageHelper.startPage(pageNum,pageSize);
            List<Gateway> list = gatewayDao.fuzzySearch(propertyId,KeyWords);
            PageInfo<Gateway> pageInfo=new PageInfo<>(list);
            List<Gateway> pageList = pageInfo.getList();
            return pageList;
        } else {
            //查询网卡
            PageHelper.startPage(pageNum,pageSize);
            List<NetworkCard> list =NetworkCardDao.fuzzySearch(propertyId,KeyWords);
            PageInfo<NetworkCard> pageInfo=new PageInfo<>(list);
            List<NetworkCard> pageList = pageInfo.getList();
            return pageList;
        }
    }
}
