package com.tianjian.property.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`tj_user`")
public class User implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "`user_id`")
    private Integer userId;
    /**
     * 备注
     */
    @Column(name = "`phone`")
    private String phone;
    /**
     * 备注
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 小程序用户角色  1管理员   2普通用户
     */
    @Column(name = "`role`")
    private Integer role;

    /**
     * 添加时间
     */
    @Column(name = "`add_time`")
    private String addTime;

    /**
     * 修改时间
     */
    @Column(name = "`update_time`")
    private String updateTime;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取小程序用户角色  1管理员   2普通用户
     *
     * @return role - 小程序用户角色  1管理员   2普通用户
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置小程序用户角色  1管理员   2普通用户
     *
     * @param role 小程序用户角色  1管理员   2普通用户
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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
        return "User{" +
                "id=" + id +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}