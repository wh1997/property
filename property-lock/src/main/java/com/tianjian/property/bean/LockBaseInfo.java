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
    private String lockid;
    //维护版本 对应小程序DNA信息的initFlag
    @Column(name = "lock_tag")
    private String locktag;
    //门锁MAC
    @Column(name = "lock_mac")
    private String lockmac;
    //硬件版本号
    @Column(name = "hardwareversion")
    private String hardwareversion;
    //软件版本 对应小程序DNA信息的firmwareVersion
    @Column(name = "softwareversion")
    private String softwareversion;
    //门锁类型
    @Column(name = "lock_type")
    private Integer locktype;
    //初始化状态标识   0~1,0—门锁为初始化状态; 1—非初始状态,已经添加了管理钥匙
    @Column(name = "initstatus")
    private Integer initstatus;
    //最大音量
    @Column(name = "maxvolume")
    private Integer maxvolume;
    //最大用户数
    @Column(name = "maxuser")
    private Integer maxuser;
    //蓝牙锁支持的命令版本号对应小程序DNA信息的bleProtocolVersion
    @Column(name = "bleprotocolver")
    private Integer bleprotocolver;
    //无线模组类型
    @Column(name = "rfmoduletype")
    private Integer rfmoduletype;
    //联网模块的MAC   带433模块必填
    @Column(name = "rfmodulemac")
    private String rfmodulemac;
    //创建时间
    @Column(name = "createtime")
    private String createtime;
    //修改时间
    @Column(name = "updatetime")
    private String updatetime;
    //设备添加人
    @Column(name = "addpeople")
    private String addpeople;
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

    public LockBaseInfo(Integer id, String lockid, String locktag, String lockmac, String hardwareversion, String softwareversion, Integer locktype, Integer initstatus, Integer maxvolume, Integer maxuser, Integer bleprotocolver, Integer rfmoduletype, String rfmodulemac,  String createtime, String updatetime, String addpeople, String vendor, Integer status, String remark) {
        this.id = id;
        this.lockid = lockid;
        this.locktag = locktag;
        this.lockmac = lockmac;
        this.hardwareversion = hardwareversion;
        this.softwareversion = softwareversion;
        this.locktype = locktype;
        this.initstatus = initstatus;
        this.maxvolume = maxvolume;
        this.maxuser = maxuser;
        this.bleprotocolver = bleprotocolver;
        this.rfmoduletype = rfmoduletype;
        this.rfmodulemac = rfmodulemac;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.addpeople = addpeople;
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

    public String getLockid() {
        return lockid;
    }

    public void setLockid(String lockid) {
        this.lockid = lockid;
    }

    public String getLocktag() {
        return locktag;
    }

    public void setLocktag(String locktag) {
        this.locktag = locktag;
    }

    public String getLockmac() {
        return lockmac;
    }

    public void setLockmac(String lockmac) {
        this.lockmac = lockmac;
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

    public Integer getLocktype() {
        return locktype;
    }

    public void setLocktype(Integer locktype) {
        this.locktype = locktype;
    }

    public Integer getInitstatus() {
        return initstatus;
    }

    public void setInitstatus(Integer initstatus) {
        this.initstatus = initstatus;
    }

    public Integer getMaxvolume() {
        return maxvolume;
    }

    public void setMaxvolume(Integer maxvolume) {
        this.maxvolume = maxvolume;
    }

    public Integer getMaxuser() {
        return maxuser;
    }

    public void setMaxuser(Integer maxuser) {
        this.maxuser = maxuser;
    }

    public Integer getBleprotocolver() {
        return bleprotocolver;
    }

    public void setBleprotocolver(Integer bleprotocolver) {
        this.bleprotocolver = bleprotocolver;
    }

    public Integer getRfmoduletype() {
        return rfmoduletype;
    }

    public void setRfmoduletype(Integer rfmoduletype) {
        this.rfmoduletype = rfmoduletype;
    }

    public String getRfmodulemac() {
        return rfmodulemac;
    }

    public void setRfmodulemac(String rfmodulemac) {
        this.rfmodulemac = rfmodulemac;
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

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getAddpeople() {
        return addpeople;
    }

    public void setAddpeople(String addpeople) {
        this.addpeople = addpeople;
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
                ", lockid='" + lockid + '\'' +
                ", locktag='" + locktag + '\'' +
                ", lockmac='" + lockmac + '\'' +
                ", hardwareversion='" + hardwareversion + '\'' +
                ", softwareversion='" + softwareversion + '\'' +
                ", locktype=" + locktype +
                ", initstatus=" + initstatus +
                ", maxvolume=" + maxvolume +
                ", maxuser=" + maxuser +
                ", bleprotocolver=" + bleprotocolver +
                ", rfmoduletype=" + rfmoduletype +
                ", rfmodulemac='" + rfmodulemac + '\'' +
                ", createtime='" + createtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", addpeople='" + addpeople + '\'' +
                ", vendor='" + vendor + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                '}';
    }
}
