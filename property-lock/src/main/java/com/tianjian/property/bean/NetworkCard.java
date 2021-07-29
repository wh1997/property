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
    private String network_name;
    //设备唯一码
    @Column(name = "deviceflag")
    private String deviceflag;
    //设备厂商
    @Column(name = "network_vendor")
    private String network_vendor;
    //设备使用时间
    @Column(name = "addtime")
    private String addtime;
    //修改设备时间
    @Column(name = "updatetime")
    private String updatetime;
    //设备状态
    @Column(name = "network_status")
    private Integer network_status;
    //百为同步的设备id
    @Column(name = "propert_id")
    private Integer Property_id;
    //设备添加人
    @Column(name = "add_user")
    private Integer add_user;
    //绑定的手机号
    @Column(name = "network_phone")
    private Integer network_phone;
    //备注
    @Column(name = "remark")
    private String remark;

    public NetworkCard(Integer id, String network_name, String deviceflag, String network_vendor, String addtime, String updatetime, Integer network_status, Integer property_id, Integer add_user, Integer network_phone, String remark) {
        Id = id;
        this.network_name = network_name;
        this.deviceflag = deviceflag;
        this.network_vendor = network_vendor;
        this.addtime = addtime;
        this.updatetime = updatetime;
        this.network_status = network_status;
        Property_id = property_id;
        this.add_user = add_user;
        this.network_phone = network_phone;
        this.remark = remark;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNetwork_name() {
        return network_name;
    }

    public void setNetwork_name(String network_name) {
        this.network_name = network_name;
    }

    public String getDeviceflag() {
        return deviceflag;
    }

    public void setDeviceflag(String deviceflag) {
        this.deviceflag = deviceflag;
    }

    public String getNetwork_vendor() {
        return network_vendor;
    }

    public void setNetwork_vendor(String network_vendor) {
        this.network_vendor = network_vendor;
    }

    public String getAddtime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getNetwork_status() {
        return network_status;
    }

    public void setNetwork_status(Integer network_status) {
        this.network_status = network_status;
    }

    public Integer getProperty_id() {
        return Property_id;
    }

    public void setProperty_id(Integer property_id) {
        Property_id = property_id;
    }

    public Integer getAdd_user() {
        return add_user;
    }

    public void setAdd_user(Integer add_user) {
        this.add_user = add_user;
    }

    public Integer getNetwork_phone() {
        return network_phone;
    }

    public void setNetwork_phone(Integer network_phone) {
        this.network_phone = network_phone;
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
                ", network_name='" + network_name + '\'' +
                ", deviceflag='" + deviceflag + '\'' +
                ", network_vendor='" + network_vendor + '\'' +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", network_status=" + network_status +
                ", Property_id=" + Property_id +
                ", add_user=" + add_user +
                ", network_phone=" + network_phone +
                ", remark='" + remark + '\'' +
                '}';
    }
}
