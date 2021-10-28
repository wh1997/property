package com.tianjian.property.dao;

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
public interface GatewayDao extends BaseDao<Gateway> {
    @Select({"<script>" +
            " SELECT gateway_name, gateway_mac,deviceseq " +
            "FROM tj_gateway WHERE id = #{id} AND status != 5"+
            "</script>"})
    Map<String,Object> findById(Integer id);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_gateway WHERE " +
            "<if test='keyWord !=null'> deviceseq LIKE #{keyWord} OR gateway_name LIKE #{keyWord} OR gateway_mac LIKE #{keyWord} OR gateway_id LIKE #{keyWord} AND </if>"+
            "project = #{propertyId} AND status != 5"+
            "</script>"})
    List<Gateway> findByPropertyId(Integer propertyId,String keyWord);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_gateway WHERE id = #{equipmentId} AND status != 5"+
            "</script>"})
    Gateway selectById(Integer equipmentId);
   @Insert({"<script>" +
           " INSERT INTO tj_gateway" +
           "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='gatewayId != null'>gateway_id ,</if> " +
           " <if test='deviceseq != null'>deviceseq,</if> " +
           " <if test='gatewayName != null'>gateway_name ,</if> " +
           " <if test='gatewayMac != null'>gateway_mac ,</if> " +
           " <if test='gatewayType != null'>gateway_type ,</if> " +
           " <if test='hardwareVersion != null'>hardware_version ,</if> " +
           " <if test='softwareVersion != null'>software_version ,</if> " +
           " <if test='project != null'>project, </if> " +
           " <if test='vendor != null'>vendor, </if> " +
           " <if test='createTime != null'>create_time, </if> " +
           " <if test='discardTime != null'>discard_time ,</if> " +
           " <if test='status != null'>status, </if> " +
           " <if test='remark != null'>remark, </if> " +
           "</trim>"+
           "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='gatewayId  != null'> #{gatewayId}, </if> " +
           " <if test='deviceseq  != null'> #{deviceseq}, </if>" +
           " <if test='gatewayName  != null'> #{gatewayName},</if> " +
           " <if test='gatewayMac   != null'>#{gatewayMac}, </if> " +
           " <if test='gatewayType  != null'>#{gatewayType} ,</if> " +
           " <if test='hardwareVersion != null'>#{hardwareVersion} ,</if> " +
           " <if test='softwareVersion  != null'>#{softwareVersion} ,</if> " +
           " <if test='project != null'> #{project} ,</if> " +
           " <if test='vendor != null'> #{vendor} ,</if> " +
           " <if test='createTime != null'> #{createTime} ,</if> " +
           " <if test='discardTime != null'> #{discardTime} ,</if> " +
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
            " AND project = #{propertyId}   " +
            " AND status != 5"+
            "</script>"})
    List<Gateway> fuzzySearch(Integer propertyId,String keyWord);
    @Update({"UPDATE tj_gateway SET `status`= 5 WHERE gateway_id = #{gatewayId}"})
    int updateByGatewayId(String gatewayId);
}
