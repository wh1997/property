package com.tianjian.property.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`tj_lock_log`")
public class LockLog implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 门id
     */
    @Column(name = "`lock_id`")
    private Integer lockId;

    /**
     * 门锁类型
     */
    @Column(name = "`lock_type`")
    private Integer lockType;

    /**
     * 门锁MAC
     */
    @Column(name = "`lock_mac`")
    private String lockMac;

    /**
     * 开锁时间
     */
    @Column(name = "`record_time`")
    private Date recordTime;

    /**
     * 小区id
     */
    @Column(name = "`property_id`")
    private Integer propertyId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 添加时间
     */
    @Column(name = "`add_time`")
    private Date addTime;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取门id
     *
     * @return lock_id - 门id
     */
    public Integer getLockId() {
        return lockId;
    }

    /**
     * 设置门id
     *
     * @param lockId 门id
     */
    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    /**
     * 获取门锁类型
     *
     * @return lock_type - 门锁类型
     */
    public Integer getLockType() {
        return lockType;
    }

    /**
     * 设置门锁类型
     *
     * @param lockType 门锁类型
     */
    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }

    /**
     * 获取门锁MAC
     *
     * @return lock_mac - 门锁MAC
     */
    public String getLockMac() {
        return lockMac;
    }

    /**
     * 设置门锁MAC
     *
     * @param lockMac 门锁MAC
     */
    public void setLockMac(String lockMac) {
        this.lockMac = lockMac == null ? null : lockMac.trim();
    }

    /**
     * 获取开锁时间
     *
     * @return record_time - 开锁时间
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     * 设置开锁时间
     *
     * @param recordTime 开锁时间
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    /**
     * 获取小区id
     *
     * @return property_id - 小区id
     */
    public Integer getPropertyId() {
        return propertyId;
    }

    /**
     * 设置小区id
     *
     * @param propertyId 小区id
     */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lockId=").append(lockId);
        sb.append(", lockType=").append(lockType);
        sb.append(", lockMac=").append(lockMac);
        sb.append(", recordTime=").append(recordTime);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", userId=").append(userId);
        sb.append(", addTime=").append(addTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}