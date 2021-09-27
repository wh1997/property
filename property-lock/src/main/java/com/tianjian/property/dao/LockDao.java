package com.tianjian.property.dao;

import com.tianjian.property.bean.Lock;
import com.tianjian.property.dao.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LockDao extends BaseDao<Lock> {
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_lock WHERE door_id = #{doorid} AND lock_status=0 "+
            "</script>"})
    List<Lock> selectByDoorid(Integer doorid);
    @Insert({"<script>" +
            " INSERT INTO tj_lock" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorId != null'>door_id ,</if> " +
            " <if test='lockStatus != null'>lock_status,</if> " +
            " <if test='lockFacilityId != null'>lock_facility_id ,</if> " +
            " <if test='lockGatewayId != null'>Lock_gateway_id ,</if> " +
            " <if test='facilityType != null'>facility_type ,</if> " +
            " <if test='addTime != null'>addtime ,</if> " +
            " <if test='updateTime != null'>updatetime ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorId  != null'> #{doorId}, </if> " +
            " <if test='lockStatus  != null'> #{lockStatus}, </if>" +
            " <if test='lockFacilityId  != null'> #{lockFacilityId},</if> " +
            " <if test='lockGatewayId   != null'>#{lockGatewayId}, </if> " +
            " <if test='facilityType  != null'>#{facilityType} ,</if> " +
            " <if test='addTime != null'>#{addTime} ,</if> " +
            " <if test='updateTime  != null'>#{updateTime} ,</if> " +
            " <if test='remark != null'> #{remark} ,</if> " +
            "</trim>"+
            "</script>"})
    void inster(Lock lock);
    @Update({"UPDATE tj_lock SET `Lock_gateway_id`=-1 WHERE id = #{lock}"})
    void updateGatewayId(Integer lock);
    @Select({"SELECT * FROM  tj_lock  WHERE Lock_gateway_id = #{id}"})
    List<Lock> selectByGatewayId(Integer id);
}
