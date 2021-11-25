package com.tianjian.property.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`tj_lock_user`")
public class TjLockUser implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;

    /**
     * 门id
     */
    @Column(name = "`door_id`")
    private Integer doorId;

    /**
     * 添加的用户汇享家开门用户id
     */
    @Column(name = "`lock_user_id`")
    private Integer lockUserId;

    /**
     * 添加人
     */
    @Column(name = "`add_person`")
    private Integer addPerson;

    /**
     * 状态0 使用  1不使用
     */
    @Column(name = "`status`")
    private Integer status;

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
     * 获取添加的用户汇享家开门用户id
     *
     * @return lock_user_id - 添加的用户汇享家开门用户id
     */
    public Integer getLockUserId() {
        return lockUserId;
    }

    /**
     * 设置添加的用户汇享家开门用户id
     *
     * @param lockUserId 添加的用户汇享家开门用户id
     */
    public void setLockUserId(Integer lockUserId) {
        this.lockUserId = lockUserId;
    }

    /**
     * 获取添加人
     *
     * @return add_person - 添加人
     */
    public Integer getAddPerson() {
        return addPerson;
    }

    /**
     * 设置添加人
     *
     * @param addPerson 添加人
     */
    public void setAddPerson(Integer addPerson) {
        this.addPerson = addPerson;
    }

    /**
     * 获取状态0 使用  1不使用
     *
     * @return status - 状态0 使用  1不使用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0 使用  1不使用
     *
     * @param status 状态0 使用  1不使用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", doorId=").append(doorId);
        sb.append(", lockUserId=").append(lockUserId);
        sb.append(", addPerson=").append(addPerson);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}