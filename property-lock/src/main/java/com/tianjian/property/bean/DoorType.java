package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/6/16
 */
@Table(name = "tj_door_type")
public class DoorType implements Serializable {
    //主键id
    @Id
    @Column(name = "id",insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //城市id
    @Column(name = "door_type")
    private String doorType ;
    //城市名称
    @Column(name = "addtime")
    private String addTime ;
    //区域id
    @Column(name = "remark")
    private String remark	;

    public DoorType() {
        super();
    }

    public DoorType(Integer id, String doorType, String addTime, String remark) {
        this.id = id;
        this.doorType = doorType;
        this.addTime = addTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoorType() {
        return doorType;
    }

    public void setDoorType(String doorType) {
        this.doorType = doorType;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "DoorType{" +
                "id=" + id +
                ", doorType='" + doorType + '\'' +
                ", addTime='" + addTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
