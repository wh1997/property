package com.tianjian.property.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`tj_lock_authorization`")
public class LockAuthorization implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 门id
     */
    @Column(name = "`door_id`")
    private Integer doorId;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 用户状态
     */
    @Column(name = "`user_status`")
    private Integer userStatus;

    /**
     * 入住时间
     */
    @Column(name = "`entertime`")
    private Date entertime;

    /**
     * 离开时间
     */
    @Column(name = "`leavatime`")
    private Date leavatime;

    /**
     * 授权开门方式
     */
    @Column(name = "`opendoor_status`")
    private String opendoorStatus;

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
     * @return door_id - 门id
     */
    public Integer getDoorId() {
        return doorId;
    }

    /**
     * 设置门id
     *
     * @param doorId 门id
     */
    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
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
     * 获取用户状态
     *
     * @return user_status - 用户状态
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态
     *
     * @param userStatus 用户状态
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 获取入住时间
     *
     * @return entertime - 入住时间
     */
    public Date getEntertime() {
        return entertime;
    }

    /**
     * 设置入住时间
     *
     * @param entertime 入住时间
     */
    public void setEntertime(Date entertime) {
        this.entertime = entertime;
    }

    /**
     * 获取离开时间
     *
     * @return leavatime - 离开时间
     */
    public Date getLeavatime() {
        return leavatime;
    }

    /**
     * 设置离开时间
     *
     * @param leavatime 离开时间
     */
    public void setLeavatime(Date leavatime) {
        this.leavatime = leavatime;
    }

    /**
     * 获取授权开门方式
     *
     * @return opendoor_status - 授权开门方式
     */
    public String getOpendoorStatus() {
        return opendoorStatus;
    }

    /**
     * 设置授权开门方式
     *
     * @param opendoorStatus 授权开门方式
     */
    public void setOpendoorStatus(String opendoorStatus) {
        this.opendoorStatus = opendoorStatus == null ? null : opendoorStatus.trim();
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
        sb.append(", doorId=").append(doorId);
        sb.append(", userId=").append(userId);
        sb.append(", userStatus=").append(userStatus);
        sb.append(", entertime=").append(entertime);
        sb.append(", leavatime=").append(leavatime);
        sb.append(", opendoorStatus=").append(opendoorStatus);
        sb.append(", addtime=").append(addtime);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}