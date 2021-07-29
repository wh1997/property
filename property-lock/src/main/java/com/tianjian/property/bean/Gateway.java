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
    private String gatewayid;
    //网关序列号
    @Column(name = "deviceseq")
    private String deviceseq;
    //网关名称
    @Column(name = "gateway_name")
    private String gatewayname;
    //网关MAC
    @Column(name = "gateway_mac")
    private String gatewaymac;
    //网关类型
    @Column(name = "gateway_type")
    private Integer gatewaytype;
    //硬件版本号
    @Column(name = "hardwareversion")
    private String hardwareversion;
    //软件版本号
    @Column(name = "softwareversion")
    private String softwareversion;
    //创建时间
    @Column(name = "createtime")
    private String createtime;
    //废弃时间
    @Column(name = "discardtime")
    private String discardtime;
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
    @Column(name = "id")
    private String remark;

    public Gateway() {
        super();
    }

    public Gateway(Integer id, String gatewayid, String deviceseq, String gatewayname, String gatewaymac, Integer gatewaytype, String hardwareversion, String softwareversion, String createtime, String discardtime, Integer status, Integer project, String vendor, String remark) {
        this.id = id;
        this.gatewayid = gatewayid;
        this.deviceseq = deviceseq;
        this.gatewayname = gatewayname;
        this.gatewaymac = gatewaymac;
        this.gatewaytype = gatewaytype;
        this.hardwareversion = hardwareversion;
        this.softwareversion = softwareversion;
        this.createtime = createtime;
        this.discardtime = discardtime;
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

    public String getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(String gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getDeviceseq() {
        return deviceseq;
    }

    public void setDeviceseq(String deviceseq) {
        this.deviceseq = deviceseq;
    }

    public String getGatewayname() {
        return gatewayname;
    }

    public void setGatewayname(String gatewayname) {
        this.gatewayname = gatewayname;
    }

    public String getGatewaymac() {
        return gatewaymac;
    }

    public void setGatewaymac(String gatewaymac) {
        this.gatewaymac = gatewaymac;
    }

    public Integer getGatewaytype() {
        return gatewaytype;
    }

    public void setGatewaytype(Integer gatewaytype) {
        this.gatewaytype = gatewaytype;
    }

    public String getHardwareversion() {
        return hardwareversion;
    }

    public void setHardwareversion(String hardwareversion) {
        this.hardwareversion = hardwareversion;
    }

    public String getSoftwareversion() {
        return softwareversion;
    }

    public void setSoftwareversion(String softwareversion) {
        this.softwareversion = softwareversion;
    }

    public String getCreatetime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDiscardtime() {
        return discardtime;
    }

    public void setDiscardtime(String discardtime) {
        this.discardtime = discardtime;
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
                ", gatewayid='" + gatewayid + '\'' +
                ", deviceseq='" + deviceseq + '\'' +
                ", gatewayname='" + gatewayname + '\'' +
                ", gatewaymac='" + gatewaymac + '\'' +
                ", gatewaytype=" + gatewaytype +
                ", hardwareversion='" + hardwareversion + '\'' +
                ", softwareversion='" + softwareversion + '\'' +
                ", createtime='" + createtime + '\'' +
                ", discardtime='" + discardtime + '\'' +
                ", status=" + status +
                ", project=" + project +
                ", vendor='" + vendor + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

