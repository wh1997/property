package com.tianjian.property.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/7/5
 */
@Table(name = "tj_baiwei_old_id")
public class BaiWeiId {
    //主键id
    @Id
    @Column(name = "id", insertable = false)
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    //百为项目id
    @Column(name = "bw_property_id")
    private Integer bwPropertyId;
    //老门禁项目id
    @Column(name = "tj_oldProperty_id")
    private Integer tjOldPropertyId;
    //项目名称
    @Column(name = "property_name")
    private String propertyName;
    //添加时间
    @Column(name = "add_time")
    private String addTime;
    //更新时间
    @Column(name = "update_time")
    private String usdateTime;
    //备注
    @Column(name = "remark")
    private String remark;

    public BaiWeiId() {
        super();
    }

    public BaiWeiId(Integer id, Integer bwPropertyId, Integer tjOldPropertyId, String propertyName, String addTime, String usdateTime, String remark) {
        this.id = id;
        this.bwPropertyId = bwPropertyId;
        this.tjOldPropertyId = tjOldPropertyId;
        this.propertyName = propertyName;
        this.addTime = addTime;
        this.usdateTime = usdateTime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBwPropertyId() {
        return bwPropertyId;
    }

    public void setBwPropertyId(Integer bwPropertyId) {
        this.bwPropertyId = bwPropertyId;
    }

    public Integer getTjOldPropertyId() {
        return tjOldPropertyId;
    }

    public void setTjOldPropertyId(Integer tjOldPropertyId) {
        this.tjOldPropertyId = tjOldPropertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getAddTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        return format;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUsdateTime() {
        return usdateTime;
    }

    public void setUsdateTime(String usdateTime) {
        this.usdateTime = usdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BaiWeiId{" +
                "id=" + id +
                ", bwPropertyId=" + bwPropertyId +
                ", tjOldPropertyId=" + tjOldPropertyId +
                ", propertyName='" + propertyName + '\'' +
                ", addTime='" + addTime + '\'' +
                ", usdateTime='" + usdateTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

