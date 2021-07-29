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
    private String doortype ;
    //城市名称
    @Column(name = "addtime")
    private String addtime ;
    //区域id
    @Column(name = "remark")
    private String remark	;

    public DoorType() {
        super();
    }

    public DoorType(Integer id, String doortype, String addtime, String remark) {
        this.id = id;
        this.doortype = doortype;
        this.addtime = addtime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoortype() {
        return doortype;
    }

    public void setDoortype(String doortype) {
        this.doortype = doortype;
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
                ", doortype=" + doortype +
                ", addtime=" + addtime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
