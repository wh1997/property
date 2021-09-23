package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//角色权限表
@Table(name = "tj_role")
public class Role implements Serializable {
    //主键id
    @Id
    @Column(name = "id",insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Long Id;
    //用户id
    @Column(name = "user_id")
    private Integer userId;
    //角色
    @Column(name = "Role")
    private Integer role;
    //管理项目
    @Column(name = "property_id")
    private Integer propertyId;
    //添加时间
    @Column(name = "addtime")
    private String addTime;
    //修改设备时间
    @Column(name = "updatetime")
    private String updateTime;
    //备注
    @Column(name = "remark")
    private String remark;

    public Role() {
        super();
    }

    public Role(Long id, Integer userId, Integer role, Integer propertyId, String addTime, String updateTime, String remark) {
        Id = id;
        this.userId = userId;
        this.role = role;
        this.propertyId = propertyId;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.remark = remark;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
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

    public Integer getRole() {
        return role;
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

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", role=" + role +
                ", propertyId=" + propertyId +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
