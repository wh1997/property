package com.tianjian.property.management.dao;

import com.tianjian.property.bean.Lock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LockDao {
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_lock WHERE door_id = #{doorid} AND lock_status=0 "+
            "</script>"})
    List<Lock> selectByDoorid(Integer doorid);
    @Insert({"<script>" +
            " INSERT INTO tj_lock" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorid != null'>door_id ,</if> " +
            " <if test='lockstatus != null'>lock_status,</if> " +
            " <if test='lockfacilityid != null'>lock_facility_id ,</if> " +
            " <if test='lockgatewayid != null'>Lock_gateway_id ,</if> " +
            " <if test='facilitytype != null'>facility_type ,</if> " +
            " <if test='addtime != null'>addtime ,</if> " +
            " <if test='updatetime != null'>updatetime ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorid  != null'> #{doorid}, </if> " +
            " <if test='lockstatus  != null'> #{lockstatus}, </if>" +
            " <if test='lockfacilityid  != null'> #{lockfacilityid},</if> " +
            " <if test='lockgatewayid   != null'>#{lockgatewayid}, </if> " +
            " <if test='facilitytype  != null'>#{facilitytype} ,</if> " +
            " <if test='addtime != null'>#{addtime} ,</if> " +
            " <if test='updatetime  != null'>#{updatetime} ,</if> " +
            " <if test='remark != null'> #{remark} ,</if> " +
            "</trim>"+
            "</script>"})
    void inster(Lock lock);
    @Update({"UPDATE tj_lock SET `Lock_gateway_id`=NULL WHERE id = #{lock}"})
    void updateGatewayId(Integer lock);
    @Select({"SELECT * FROM  tj_lock  WHERE Lock_gateway_id = #{id}"})
    List<Lock> selectByGatewayId(Integer id);
}
