package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//网卡设备表
@Table(name = "tj_network_card")
public class NetworkCard implements Serializable {
    //主键id
    @Id
    @Column(name = "id",insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer Id;
    //设备名称
    @Column(name = "network_name")
    private String networkName;
    //设备唯一码
    @Column(name = "deviceflag")
    private String deviceFlag;
    //设备厂商
    @Column(name = "network_vendor")
    private String networkVendor;
    //设备使用时间
    @Column(name = "addtime")
    private String addTime;
    //修改设备时间
    @Column(name = "updatetime")
    private String updateTime;
    //设备状态
    @Column(name = "network_status")
    private Integer networkStatus;
    //百为同步的设备id
    @Column(name = "property_id")
    private Integer PropertyId;
    //设备添加人
    @Column(name = "add_user")
    private Integer addUser;
    //绑定的手机号
    @Column(name = "network_phone")
    private String networkPhone;
    //备注
    @Column(name = "remark")
    private String remark;

    public NetworkCard(Integer id, String networkName, String deviceFlag, String networkVendor, String addTime, String updateTime, Integer networkStatus, Integer propertyId, Integer addUser, String networkPhone, String remark) {
        Id = id;
        this.networkName = networkName;
        this.deviceFlag = deviceFlag;
        this.networkVendor = networkVendor;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.networkStatus = networkStatus;
        PropertyId = propertyId;
        this.addUser = addUser;
        this.networkPhone = networkPhone;
        this.remark = remark;
    }

    public NetworkCard() {
        super();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getDeviceFlag() {
        return deviceFlag;
    }

    public void setDeviceFlag(String deviceFlag) {
        this.deviceFlag = deviceFlag;
    }

    public String getNetworkVendor() {
        return networkVendor;
    }

    public void setNetworkVendor(String networkVendor) {
        this.networkVendor = networkVendor;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(Integer networkStatus) {
        this.networkStatus = networkStatus;
    }

    public Integer getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(Integer propertyId) {
        PropertyId = propertyId;
    }

    public Integer getAddUser() {
        return addUser;
    }

    public void setAddUser(Integer addUser) {
        this.addUser = addUser;
    }

    public String getNetworkPhone() {
        return networkPhone;
    }

    public void setNetworkPhone(String networkPhone) {
        this.networkPhone = networkPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "NetworkCard{" +
                "Id=" + Id +
                ", networkName='" + networkName + '\'' +
                ", deviceFlag='" + deviceFlag + '\'' +
                ", networkVendor='" + networkVendor + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", networkStatus=" + networkStatus +
                ", PropertyId=" + PropertyId +
                ", addUser=" + addUser +
                ", networkPhone=" + networkPhone +
                ", remark='" + remark + '\'' +
                '}';
    }
}
