package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "tj_lockbaseinfo")
public class LockBaseInfo implements Serializable {
    //Id
    @Id
    @Column(name = "id",insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //维护版本 对应小程序DNA信息的initFlag
    @Column(name = "lock_id")
    private String lockId;
    //维护版本 对应小程序DNA信息的initFlag
    @Column(name = "lock_tag")
    private String lockTag;
    //门锁MAC
    @Column(name = "lock_mac")
    private String lockMac;
    //硬件版本号
    @Column(name = "hardwareersion")
    private String hardwareVersion;
    //软件版本 对应小程序DNA信息的firmwareVersion
    @Column(name = "softwareversion")
    private String softwareVersion;
    //门锁类型
    @Column(name = "lock_type")
    private Integer lockType;
    //初始化状态标识   0~1,0—门锁为初始化状态; 1—非初始状态,已经添加了管理钥匙
    @Column(name = "initstatus")
    private Integer initStatus;
    //最大音量
    @Column(name = "maxvolume")
    private Integer maxVolume;
    //最大用户数
    @Column(name = "maxuser")
    private Integer maxUser;
    //蓝牙锁支持的命令版本号对应小程序DNA信息的bleProtocolVersion
    @Column(name = "bleprotocolver")
    private Integer bleproTocolver;
    //无线模组类型
    @Column(name = "rfmoduletype")
    private Integer rfmoduleType;
    //联网模块的MAC   带433模块必填
    @Column(name = "rfmodulemac")
    private String rfmoduleMac;
    //创建时间
    @Column(name = "createtime")
    private String createTime;
    //修改时间
    @Column(name = "updatetime")
    private String updateTime;
    //设备添加人
    @Column(name = "addpeople")
    private String addPeople;
    //厂商
    @Column(name = "vendor")
    private String vendor;
    //设备状态
    @Column(name = "status")
    private Integer status;
    //备注
    @Column(name = "remark")
    private String remark;

    public LockBaseInfo() {
        super();
    }

    public LockBaseInfo(Integer id, String lockId, String lockTag, String lockMac, String hardwareVersion, String softwareVersion, Integer lockType, Integer initStatus, Integer maxVolume, Integer maxUser, Integer bleproTocolver, Integer rfmoduleType, String rfmoduleMac, String createTime, String updateTime, String addPeople, String vendor, Integer status, String remark) {
        this.id = id;
        this.lockId = lockId;
        this.lockTag = lockTag;
        this.lockMac = lockMac;
        this.hardwareVersion = hardwareVersion;
        this.softwareVersion = softwareVersion;
        this.lockType = lockType;
        this.initStatus = initStatus;
        this.maxVolume = maxVolume;
        this.maxUser = maxUser;
        this.bleproTocolver = bleproTocolver;
        this.rfmoduleType = rfmoduleType;
        this.rfmoduleMac = rfmoduleMac;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.addPeople = addPeople;
        this.vendor = vendor;
        this.status = status;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCreateTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public String getLockTag() {
        return lockTag;
    }

    public void setLockTag(String lockTag) {
        this.lockTag = lockTag;
    }

    public String getLockMac() {
        return lockMac;
    }

    public void setLockMac(String lockMac) {
        this.lockMac = lockMac;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public Integer getLockType() {
        return lockType;
    }

    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }

    public Integer getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Integer initStatus) {
        this.initStatus = initStatus;
    }

    public Integer getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Integer maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Integer getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(Integer maxUser) {
        this.maxUser = maxUser;
    }

    public Integer getBleproTocolver() {
        return bleproTocolver;
    }

    public void setBleproTocolver(Integer bleproTocolver) {
        this.bleproTocolver = bleproTocolver;
    }

    public Integer getRfmoduleType() {
        return rfmoduleType;
    }

    public void setRfmoduleType(Integer rfmodueType) {
        this.rfmoduleType = rfmodueType;
    }

    public String getRfmoduleMac() {
        return rfmoduleMac;
    }

    public void setRfmoduleMac(String rfmoduleMac) {
        this.rfmoduleMac = rfmoduleMac;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getAddPeople() {
        return addPeople;
    }

    public void setAddPeople(String addPeople) {
        this.addPeople = addPeople;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LockBaseInfo{" +
                "id=" + id +
                ", lockId='" + lockId + '\'' +
                ", lockTag='" + lockTag + '\'' +
                ", lockMac='" + lockMac + '\'' +
                ", hardwareVersion='" + hardwareVersion + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", lockType=" + lockType +
                ", initStatus=" + initStatus +
                ", maxVolume=" + maxVolume +
                ", maxUser=" + maxUser +
                ", bleproTocolver=" + bleproTocolver +
                ", rfmodueType=" + rfmoduleType +
                ", rfmoduleMac='" + rfmoduleMac + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", addPeople='" + addPeople + '\'' +
                ", vendor='" + vendor + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
