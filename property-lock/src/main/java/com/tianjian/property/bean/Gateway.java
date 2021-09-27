package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "tj_gateway")
public class Gateway implements Serializable {
    //Id
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "id",insertable = false)
    private Integer id;
    //网关id
    @Column(name = "gateway_id")
    private String gatewayId;
    //网关序列号
    @Column(name = "deviceseq")
    private String deviceseq;
    //网关名称
    @Column(name = "gateway_name")
    private String gatewayName;
    //网关MAC
    @Column(name = "gateway_mac")
    private String gatewayMac;
    //网关类型
    @Column(name = "gateway_type")
    private Integer gatewayType;
    //硬件版本号
    @Column(name = "hardwareversion")
    private String hardwareVersion;
    //软件版本号
    @Column(name = "softwareversion")
    private String softwareVersion;
    //创建时间
    @Column(name = "createtime")
    private String createTime;
    //废弃时间
    @Column(name = "discardtime")
    private String discardTime;
    //网关状态  3在线4离线5废弃
    @Column(name = "status")
    private Integer status;
    //对应的项目小区
    @Column(name = "Project")
    private Integer project;
    //厂商
    @Column(name = "vendor")
    private String vendor;
    //备注
    @Column(name = "remark")
    private String remark;

    public Gateway() {
        super();
    }

    public Gateway(Integer id, String gatewayId, String deviceseq, String gatewayName, String gatewayMac, Integer gatewayType, String hardwareVersion, String softwareVersion, String createTime, String discardTime, Integer status, Integer project, String vendor, String remark) {
        this.id = id;
        this.gatewayId = gatewayId;
        this.deviceseq = deviceseq;
        this.gatewayName = gatewayName;
        this.gatewayMac = gatewayMac;
        this.gatewayType = gatewayType;
        this.hardwareVersion = hardwareVersion;
        this.softwareVersion = softwareVersion;
        this.createTime = createTime;
        this.discardTime = discardTime;
        this.status = status;
        this.project = project;
        this.vendor = vendor;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getDeviceseq() {
        return deviceseq;
    }

    public void setDeviceseq(String deviceseq) {
        this.deviceseq = deviceseq;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getGatewayMac() {
        return gatewayMac;
    }

    public void setGatewayMac(String gatewayMac) {
        this.gatewayMac = gatewayMac;
    }

    public Integer getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(Integer gatewayType) {
        this.gatewayType = gatewayType;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDiscardTime() {
        return discardTime;
    }

    public void setDiscardTime(String discardTime) {
        this.discardTime = discardTime;
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

    public String getCreateTime() {
        return createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Gateway{" +
                "id=" + id +
                ", gatewayId='" + gatewayId + '\'' +
                ", deviceseq='" + deviceseq + '\'' +
                ", gatewayName='" + gatewayName + '\'' +
                ", gatewayMac='" + gatewayMac + '\'' +
                ", gatewayType=" + gatewayType +
                ", hardwareVersion='" + hardwareVersion + '\'' +
                ", softwareVersion='" + softwareVersion + '\'' +
                ", createTime='" + createTime + '\'' +
                ", discardTime='" + discardTime + '\'' +
                ", status=" + status +
                ", project=" + project +
                ", vendor='" + vendor + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

