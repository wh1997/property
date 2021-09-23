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
    private Integer doorId;
    //锁的状态
    @Column(name = "lock_status")
    private Integer lockStatus;
    //锁设备id
    @Column(name = "lock_facility_id")
    private Integer lockFacilityId;
    //对应的网关id
    @Column(name = "Lock_gateway_id")
    private Integer lockGatewayId;
    //设备类型
    @Column(name = "facility_type")
    private Integer facilityType;
    //添加时间
    @Column(name = "addtime")
    private String addTime;
    //修改时间
    @Column(name = "updatetime")
    private String updateTime ;
    //备注
    @Column(name = "remark")
    private String remark ;

    public Lock() {
        super();
    }

    public Lock(Integer id, Integer doorId, Integer lockStatus, Integer lockFacilityId, Integer lockGatewayId, Integer facilityType, String addTime, String updateTime, String remark) {
        this.id = id;
        this.doorId = doorId;
        this.lockStatus = lockStatus;
        this.lockFacilityId = lockFacilityId;
        this.lockGatewayId = lockGatewayId;
        this.facilityType = facilityType;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public String getAddTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Integer getLockFacilityId() {
        return lockFacilityId;
    }

    public void setLockFacilityId(Integer lockFacilityId) {
        this.lockFacilityId = lockFacilityId;
    }

    public Integer getLockGatewayId() {
        return lockGatewayId;
    }

    public void setLockGatewayId(Integer lockGatewayId) {
        this.lockGatewayId = lockGatewayId;
    }

    public Integer getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(Integer facilityType) {
        this.facilityType = facilityType;
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

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", doorId=" + doorId +
                ", lockStatus=" + lockStatus +
                ", lockFacilityId=" + lockFacilityId +
                ", lockGatewayId=" + lockGatewayId +
                ", facilityType=" + facilityType +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
