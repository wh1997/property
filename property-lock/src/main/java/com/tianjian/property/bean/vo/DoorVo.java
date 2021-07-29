package com.tianjian.property.bean.vo;

public class DoorVo {
    private  Integer id;
    private Integer numid;
    //期数名称
    private String numname;
    //楼栋id
    private Integer bulidingid;
    //楼栋名称
    private String bulidingname;
    //楼层
    private Integer floorno;
    //房号
    private String roomno;
    //门名称
    private String doorname;
    //使用状态
    private Integer status;
    //单元号
    private Integer unitno;
    //单元名称
    private String unitname;

    public DoorVo(Integer id, Integer numid, String numname, Integer bulidingid, String bulidingname, Integer floorno, String roomno, String doorname, Integer status, Integer unitno, String unitname) {
        this.id = id;
        this.numid = numid;
        this.numname = numname;
        this.bulidingid = bulidingid;
        this.bulidingname = bulidingname;
        this.floorno = floorno;
        this.roomno = roomno;
        this.doorname = doorname;
        this.status = status;
        this.unitno = unitno;
        this.unitname = unitname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumid() {
        return numid;
    }

    public void setNumid(Integer numid) {
        this.numid = numid;
    }

    public String getNumname() {
        return numname;
    }

    public void setNumname(String numname) {
        this.numname = numname;
    }

    public Integer getBulidingid() {
        return bulidingid;
    }

    public void setBulidingid(Integer bulidingid) {
        this.bulidingid = bulidingid;
    }

    public String getBulidingname() {
        return bulidingname;
    }

    public void setBulidingname(String bulidingname) {
        this.bulidingname = bulidingname;
    }

    public Integer getFloorno() {
        return floorno;
    }

    public void setFloorno(Integer floorno) {
        this.floorno = floorno;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getDoorname() {
        return doorname;
    }

    public void setDoorname(String doorname) {
        this.doorname = doorname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUnitno() {
        return unitno;
    }

    public void setUnitno(Integer unitno) {
        this.unitno = unitno;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    @Override
    public String toString() {
        return "DoorVo{" +
                "id=" + id +
                ", numid=" + numid +
                ", numname='" + numname + '\'' +
                ", bulidingid=" + bulidingid +
                ", bulidingname='" + bulidingname + '\'' +
                ", floorno=" + floorno +
                ", roomno='" + roomno + '\'' +
                ", doorname='" + doorname + '\'' +
                ", status=" + status +
                ", unitno=" + unitno +
                ", unitname='" + unitname + '\'' +
                '}';
    }
}
