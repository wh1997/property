package com.tianjian.property.management.dao;

import com.tianjian.property.bean.Gateway;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GatewayDao {
    @Select({"<script>" +
            " SELECT gateway_name, gateway_mac,deviceseq " +
            "FROM tj_gateway WHERE id = #{id}"+
            "</script>"})
    Map<String,String> findById(Integer id);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_gateway WHERE Project = #{propertyId} AND status != 5"+
            "</script>"})
    List<Gateway> findByPropertyId(Integer propertyId);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_gateway WHERE id = #{equipmentId} AND status != 5"+
            "</script>"})
    Gateway selectById(Integer equipmentId);
   @Insert({"<script>" +
           " INSERT INTO tj_lock" +
           "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='gatewayid != null'>gateway_id ,</if> " +
           " <if test='deviceseq != null'>deviceseq,</if> " +
           " <if test='gatewayname != null'>gateway_name ,</if> " +
           " <if test='gatewaymac != null'>gateway_mac ,</if> " +
           " <if test='gatewaytype != null'>gateway_type ,</if> " +
           " <if test='hardwareversion != null'>hardwareversion ,</if> " +
           " <if test='softwareversion != null'>softwareversion ,</if> " +
           " <if test='project != null'>Project </if> " +
           " <if test='vendor != null'>vendor </if> " +
           " <if test='createtime != null'>createtime </if> " +
           " <if test='discardtime != null'>discardtime </if> " +
           " <if test='status != null'>status </if> " +
           " <if test='remark != null'>remark </if> " +
           "</trim>"+
           "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='gatewayid  != null'> #{gatewayid}, </if> " +
           " <if test='deviceseq  != null'> #{deviceseq}, </if>" +
           " <if test='gatewayname  != null'> #{gatewayname},</if> " +
           " <if test='gatewaymac   != null'>#{gatewaymac}, </if> " +
           " <if test='gatewaytype  != null'>#{gatewaytype} ,</if> " +
           " <if test='hardwareversion != null'>#{hardwareversion} ,</if> " +
           " <if test='softwareversion  != null'>#{softwareversion} ,</if> " +
           " <if test='project != null'> #{project} ,</if> " +
           " <if test='vendor != null'> #{vendor} ,</if> " +
           " <if test='createtime != null'> #{createtime} ,</if> " +
           " <if test='discardtime != null'> #{discardtime} ,</if> " +
           " <if test='status != null'> #{status} ,</if> " +
           " <if test='remark != null'> #{remark} ,</if> " +
           "</trim>"+
           "</script>"})
    void inster(Gateway gateway);
    @Update({"UPDATE tj_gateway SET `status`= #{status} WHERE id = #{id}"})
    void updateStatus(Integer id, Integer status);
    @Select({"<script>" +
           " SELECT" +
            " * FROM " +
            " tj_gateway  " +
            " WHERE " +
            " deviceseq LIKE #{keyWord}  " +
            " OR gateway_name LIKE #{keyWord}  " +
            " OR gateway_mac LIKE #{keyWord}  " +
            " OR gateway_id LIKE #{keyWord}  " +
            " AND Project = #{propertyId}   " +
            " AND status != 5"+
            "</script>"})
    List<Gateway> fuzzySearch(Integer propertyId,String keyWord);
}
