package com.tianjian.property.management.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tianjian.property.bean.*;
import com.tianjian.property.bean.vo.LockBaseInfoVo;
import com.tianjian.property.dao.DoorDao;
import com.tianjian.property.dao.GatewayDao;
import com.tianjian.property.dao.LockBaseInfoDao;
import com.tianjian.property.dao.LockDao;
import com.tianjian.property.management.service.EquipmentService;
import com.tianjian.property.management.service.GatewayService;
import com.tianjian.property.utils.BeanChangeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EquipmentServiceImpl implements EquipmentService {
@Autowired
private GatewayService gatewayService;
@Autowired
private GatewayDao gatewayDao;
@Autowired
private LockBaseInfoDao lockBaseInfoDao;
@Autowired
private com.tianjian.property.dao.NetworkCardDao NetworkCardDao;
@Autowired
private LockDao lockDao;
@Autowired
private DoorDao  doorDao;
@Value("${apartment.addBluetooth}")
private String  addBluetooth;
    @Override
    @Transactional
    public Map addBluetooth(Map lockBaseInfo, Map lockAuthCode, String hardwareVersion, String softwareVersion, Integer doorid, String addpeople) throws Exception {
        String aesKey = (String) lockAuthCode.get("aesKey");
        List<Map> authCodeList = (List<Map>) lockAuthCode.get("authCodeList");
        String adminAuthCode=null;
        String generalAuthCode=null;
        String tempAuthCode=null;
        List<Map> maps = new ArrayList<>();
        for (int i = 0; i <authCodeList.size() ; i++) {
            Map map = authCodeList.get(i);
            if (map.get("adminAuthCode")!=null){
                HashMap<String, Object> hashMap = new HashMap<>();
                adminAuthCode = (String) map.get("adminAuthCode");
                hashMap.put("authCode",adminAuthCode);
                hashMap.put("authCodeType",1);
                maps.add(hashMap);
            }
            if (map.get("generalAuthCode")!=null){
                HashMap<String, Object> hashMap = new HashMap<>();
                generalAuthCode = (String) map.get("generalAuthCode");
                hashMap.put("authCode",generalAuthCode);
                hashMap.put("authCodeType",2);
                maps.add(hashMap);
            }
            if (map.get("tempAuthCode")!=null){
                HashMap<String, Object> hashMap = new HashMap<>();
                tempAuthCode = (String) map.get("tempAuthCode");
                hashMap.put("authCode",tempAuthCode);
                hashMap.put("authCodeType",3);
                maps.add(hashMap);
            }
        }
        HashMap<String, Object> lockAuth = new HashMap<>();
        lockAuth.put("aesKey",aesKey);
        lockAuth.put("authCodeList",maps);
        HashMap<String, Object> datamap = new HashMap<>();
        //是	LockBaseInfoVo 门锁基础信息
        datamap.put("lockInfoBase",lockBaseInfo);
        //是	LockAuthCode 门锁授权码
        datamap.put("lockAuthCode",lockAuth);
        //是	string 蓝牙模块的硬件版本号，可以通过小程序插件、APP的SDK添加门锁时获取到
        datamap.put("hardwareVersion",hardwareVersion);
        //是	string 蓝牙模块的软件版本号 ,可以通过小程序插件、APP的SDK添加门锁时获取到
        datamap.put("softwareVersion",softwareVersion);
        Map result = gatewayService.bindinggateway(addBluetooth, datamap);
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
                    lockInfoBase.getRfModuleMac(), aesKey,adminAuthCode,generalAuthCode, tempAuthCode,null, null,  addpeople, "慧享佳", 1, null);
            lockBaseInfoDao.inster(LockBaseInfo);
            //往锁表里添加基本信息
            Lock lock = new Lock(null, doorid, 0, LockBaseInfo.getId(), null, 0, null, null, null);
            lockDao.inster(lock);
            doorDao.updateDoorStatus(doorid);
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
            Map map= lockBaseInfoDao.selectById(equipmentId);
            return map;
        }else if (equipmentType==2){
            //查询网关
            Gateway list=  gatewayDao.selectById(equipmentId);
            //查询网关在线状态
            Integer status  = gatewayService.selectGateway(list.getGatewayId());
            list.setStatus(status);
            //修改网关的状态
            gatewayDao.updateByPrimaryKeySelective(list);
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
