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
    private Integer propertyid	;
    //小区名称
    @Column(name = "property_name")
    private String propertyname;
    //期数id
    @Column(name = "num_id")
    private Integer numid;
    //期数名称
    @Column(name = "num_name")
    private String numname;
    //楼栋id
    @Column(name = "buliding_id")
    private Integer bulidingid;
    //楼栋名称
    @Column(name = "buliding_name")
    private String bulidingname;
    //单元号
    @Column(name = "unit_no")
    private Integer unitno;
    //单元名称
    @Column(name = "unit_name")
    private String unitname;
    //楼层
    @Column(name = "floor_no")
    private Integer floorno;
    //房号
    @Column(name = "room_no")
    private String roomno;
    //门名称
    @Column(name = "door_name")
    private String doorname;
    //门类型    0大门 1楼栋门 2单元门 3公寓门
    @Column(name = "door_type")
    private Integer doortype;
    //使用状态   0在住  1闲置   2到期
    @Column(name = "status")
    private Integer status;
    //添加时间
    @Column(name = "addtime")
    private String  addtime;
    //修改时间
    @Column(name = "updatetime")
    private String updatetime;
    //创建人
    @Column(name = "create_person")
    private String createperson;
    //备注
    @Column(name = "remark")
    private String remark;

    public Door() {
        super();
    }

    public Door(Integer id, Integer propertyid, String propertyname, Integer numid, String numname, Integer bulidingid, String bulidingname, Integer unitno, String unitname, Integer floorno, String roomno, String doorname, Integer doortype, Integer status, String addtime, String updatetime, String createperson, String remark) {
        this.id = id;
        this.propertyid = propertyid;
        this.propertyname = propertyname;
        this.numid = numid;
        this.numname = numname;
        this.bulidingid = bulidingid;
        this.bulidingname = bulidingname;
        this.unitno = unitno;
        this.unitname = unitname;
        this.floorno = floorno;
        this.roomno = roomno;
        this.doorname = doorname;
        this.doortype = doortype;
        this.status = status;
        this.addtime = addtime;
        this.updatetime = updatetime;
        this.createperson = createperson;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
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

    public Integer getDoortype() {
        return doortype;
    }

    public void setDoortype(Integer doortype) {
        this.doortype = doortype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
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
                ", propertyid=" + propertyid +
                ", propertyname='" + propertyname + '\'' +
                ", numid=" + numid +
                ", numname='" + numname + '\'' +
                ", bulidingid=" + bulidingid +
                ", bulidingname='" + bulidingname + '\'' +
                ", unitno=" + unitno +
                ", unitname='" + unitname + '\'' +
                ", floorno=" + floorno +
                ", roomno='" + roomno + '\'' +
                ", doorname='" + doorname + '\'' +
                ", doortype=" + doortype +
                ", status=" + status +
                ", addtime='" + addtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", createperson='" + createperson + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
