package com.tianjian.property.bean;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

//对应门表
@Table(name = "tj_door")
public class Door implements Serializable {
    //主键id
    @Id
    @Column(name = "id",insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //小区id
    @Column(name = "property_id")
    private Integer propertyId	;
    //小区名称
    @Column(name = "property_name")
    private String propertyName;
    //期数id
    @Column(name = "num_id")
    private Integer numId;
    //期数名称
    @Column(name = "num_name")
    private String numName;
    //楼栋id
    @Column(name = "building_id")
    private Integer buildingId;
    //楼栋名称
    @Column(name = "building_name")
    private String buildingName;
    //单元号
    @Column(name = "unit_no")
    private Integer unitNo;
    //单元名称
    @Column(name = "unit_name")
    private String unitName;
    //楼层
    @Column(name = "floor_no")
    private Integer floorNo;
    //房号
    @Column(name = "room_no")
    private String roomNo;
    //门名称
    @Column(name = "door_name")
    private String doorName;
    //门类型    0大门 1楼栋门 2单元门 3公寓门
    @Column(name = "door_type")
    private Integer doorType;
    //使用状态   0在住  1闲置   2到期
    @Column(name = "status")
    private Integer status;
    //添加时间
    @Column(name = "addtime")
    private String  addTime;
    //修改时间
    @Column(name = "updatetime")
    private String updateTime;
    //创建人
    @Column(name = "create_person")
    private String createPerson;
    //备注
    @Column(name = "remark")
    private String remark;

    public Door() {
        super();
    }

    public Door(Integer id, Integer propertyId, String propertyName, Integer numId, String numName, Integer buildingId, String buildingName, Integer unitNo, String unitName, Integer floorNo, String roomNo, String doorName, Integer doorType, Integer status, String addTime, String updateTime, String createPerson, String remark) {
        this.id = id;
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.numId = numId;
        this.numName = numName;
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.unitNo = unitNo;
        this.unitName = unitName;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.doorName = doorName;
        this.doorType = doorType;
        this.status = status;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.createPerson = createPerson;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getNumId() {
        return numId;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public String getNumName() {
        return numName;
    }

    public void setNumName(String numName) {
        this.numName = numName;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Integer getDoorType() {
        return doorType;
    }

    public void setDoorType(Integer doorType) {
        this.doorType = doorType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddTime() {
        return addTime;
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

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                ", propertyId=" + propertyId +
                ", propertyName='" + propertyName + '\'' +
                ", numId=" + numId +
                ", numName='" + numName + '\'' +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", unitNo=" + unitNo +
                ", unitName='" + unitName + '\'' +
                ", floorNo=" + floorNo +
                ", roomNo='" + roomNo + '\'' +
                ", doorName='" + doorName + '\'' +
                ", doorType=" + doorType +
                ", status=" + status +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createPerson='" + createPerson + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
