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
    private Double userid;
    //角色
    @Column(name = "Role")
    private Integer role;
    //管理项目
    @Column(name = "property_id")
    private Integer propertyid;
    //添加时间
    @Column(name = "addtime")
    private String addtime;
    //修改设备时间
    @Column(name = "updatetime")
    private String updatetime;
    //备注
    @Column(name = "remark")
    private String remark;

    public Role() {
        super();
    }

    public Role(Long id, Double userid, Integer role, Integer propertyid, String addtime, String updatetime, String remark) {
        Id = id;
        this.userid = userid;
        this.role = role;
        this.propertyid = propertyid;
        this.addtime = addtime;
        this.updatetime = updatetime;
        this.remark = remark;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Double getUserid() {
        return userid;
    }

    public void setUserid(Double userid) {
        this.userid = userid;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
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
        return "Role{" +
                "Id=" + Id +
                ", userid=" + userid +
                ", role=" + role +
                ", propertyid=" + propertyid +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
