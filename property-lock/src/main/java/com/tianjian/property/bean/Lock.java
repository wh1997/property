package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//对应锁表
@Table(name = "tj_lock")
public class Lock implements Serializable {
    //主键id
    @Id
    @Column(name = "id" ,insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //对应的门id
    @Column(name = "door_id")
    private Integer doorid;
    //锁的状态
    @Column(name = "lock_status")
    private Integer lockstatus;
    //锁设备id
    @Column(name = "lock_facility_id")
    private Integer lockfacilityid;
    //对应的网关id
    @Column(name = "Lock_gateway_id")
    private Integer lockgatewayid;
    //设备类型
    @Column(name = "facility_type")
    private Integer facilitytype;
    //添加时间
    @Column(name = "addtime")
    private String addtime;
    //修改时间
    @Column(name = "updatetime")
    private String updatetime ;
    //备注
    @Column(name = "remark")
    private String remark ;

    public Lock() {
        super();
    }

    public Lock(Integer id, Integer doorid, Integer lockstatus, Integer lockfacilityid, Integer lockgatewayid, Integer facilitytype, String addtime, String updatetime, String remark) {
        this.id = id;
        this.doorid = doorid;
        this.lockstatus = lockstatus;
        this.lockfacilityid = lockfacilityid;
        this.lockgatewayid = lockgatewayid;
        this.facilitytype = facilitytype;
        this.addtime = addtime;
        this.updatetime = updatetime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorid() {
        return doorid;
    }

    public void setDoorid(Integer doorid) {
        this.doorid = doorid;
    }

    public Integer getLockstatus() {
        return lockstatus;
    }

    public void setLockstatus(Integer lockstatus) {
        this.lockstatus = lockstatus;
    }

    public Integer getLockfacilityid() {
        return lockfacilityid;
    }

    public void setLockfacilityid(Integer lockfacilityid) {
        this.lockfacilityid = lockfacilityid;
    }

    public Integer getLockgatewayid() {
        return lockgatewayid;
    }

    public void setLockgatewayid(Integer lockgatewayid) {
        this.lockgatewayid = lockgatewayid;
    }

    public Integer getFacilitytype() {
        return facilitytype;
    }

    public void setFacilitytype(Integer facilitytype) {
        this.facilitytype = facilitytype;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", doorid=" + doorid +
                ", lockstatus=" + lockstatus +
                ", lockfacilityid=" + lockfacilityid +
                ", lockgatewayid=" + lockgatewayid +
                ", facilitytype=" + facilitytype +
                ", addtime='" + addtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
