package com.tianjian.property.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`tj_useropen_lock`")
public class UseropenLock implements Serializable {
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
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 开锁方式
     */
    @Column(name = "`lock_type`")
    private Integer lockType;

    /**
     * 卡号或密码
     */
    @Column(name = "`key`")
    private String key;

    /**
     * 开锁状态
     */
    @Column(name = "`status`")
    private Integer status;

    /**
     * 有效起始时间
     */
    @Column(name = "`validstart_time`")
    private Date validstartTime;

    /**
     * 有效结束时间
     */
    @Column(name = "`validend_time`")
    private Date validendTime;

    /**
     * 数据添加时间
     */
    @Column(name = "`addtime`")
    private Date addtime;

    /**
     * 数据修改时间
     */
    @Column(name = "`updatetime`")
    private Date updatetime;

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
     * 获取开锁方式
     *
     * @return lock_type - 开锁方式
     */
    public Integer getLockType() {
        return lockType;
    }

    /**
     * 设置开锁方式
     *
     * @param lockType 开锁方式
     */
    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }

    /**
     * 获取卡号或密码
     *
     * @return key - 卡号或密码
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置卡号或密码
     *
     * @param key 卡号或密码
     */
    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    /**
     * 获取开锁状态
     *
     * @return status - 开锁状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置开锁状态
     *
     * @param status 开锁状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取有效起始时间
     *
     * @return validstart_time - 有效起始时间
     */
    public Date getValidstartTime() {
        return validstartTime;
    }

    /**
     * 设置有效起始时间
     *
     * @param validstartTime 有效起始时间
     */
    public void setValidstartTime(Date validstartTime) {
        this.validstartTime = validstartTime;
    }

    /**
     * 获取有效结束时间
     *
     * @return validend_time - 有效结束时间
     */
    public Date getValidendTime() {
        return validendTime;
    }

    /**
     * 设置有效结束时间
     *
     * @param validendTime 有效结束时间
     */
    public void setValidendTime(Date validendTime) {
        this.validendTime = validendTime;
    }

    /**
     * 获取数据添加时间
     *
     * @return addtime - 数据添加时间
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 设置数据添加时间
     *
     * @param addtime 数据添加时间
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 获取数据修改时间
     *
     * @return updatetime - 数据修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置数据修改时间
     *
     * @param updatetime 数据修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
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
        sb.append(", userId=").append(userId);
        sb.append(", lockType=").append(lockType);
        sb.append(", key=").append(key);
        sb.append(", status=").append(status);
        sb.append(", validstartTime=").append(validstartTime);
        sb.append(", validendTime=").append(validendTime);
        sb.append(", addtime=").append(addtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}