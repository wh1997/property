package com.tianjian.property.bean.vo;

public class DoorVo {
    private  Integer id;
    private Integer numId;
    //期数名称
    private String numName;
    //楼栋id
    private Integer buildingId;
    //楼栋名称
    private String buildingname;
    //楼层
    private Integer floorNo;
    //房号
    private String roomNo;
    //门名称
    private String doorName;
    //使用状态
    private Integer status;
    //单元号
    private Integer unitNo;
    //单元名称
    private String unitName;

    public DoorVo() {
        super();
    }

    public DoorVo(Integer id, Integer numId, String numName, Integer buildingId, String buildingname, Integer floorNo, String roomNo, String doorName, Integer status, Integer unitNo, String unitName) {
        this.id = id;
        this.numId = numId;
        this.numName = numName;
        this.buildingId = buildingId;
        this.buildingname = buildingname;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.doorName = doorName;
        this.status = status;
        this.unitNo = unitNo;
        this.unitName = unitName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingname() {
        return buildingname;
    }

    public void setBuildingname(String buildingname) {
        this.buildingname = buildingname;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "DoorVo{" +
                "id=" + id +
                ", numId=" + numId +
                ", numName='" + numName + '\'' +
                ", buildingId=" + buildingId +
                ", buildingname='" + buildingname + '\'' +
                ", floorNo=" + floorNo +
                ", roomNo='" + roomNo + '\'' +
                ", doorName='" + doorName + '\'' +
                ", status=" + status +
                ", unitNo=" + unitNo +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}
