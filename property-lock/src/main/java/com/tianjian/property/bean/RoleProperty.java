package com.tianjian.property.bean;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`tj_role_property`")
public class RoleProperty implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`role_id`")
    private Integer roleId;

    /**
     * 对应tj_baiwei_old_id表id
     */
    @Column(name = "`property_id`")
    private Integer propertyId;

    /**
     * 0:未启用1:启用
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
     * @return role_id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取对应tj_baiwei_old_id表id
     *
     * @return property_id - 对应tj_baiwei_old_id表id
     */
    public Integer getPropertyId() {
        return propertyId;
    }

    /**
     * 设置对应tj_baiwei_old_id表id
     *
     * @param propertyId 对应tj_baiwei_old_id表id
     */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    /**
     * 获取0:未启用1:启用
     *
     * @return status - 0:未启用1:启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:未启用1:启用
     *
     * @param status 0:未启用1:启用
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
        sb.append(", roleId=").append(roleId);
        sb.append(", propertyId=").append(propertyId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}