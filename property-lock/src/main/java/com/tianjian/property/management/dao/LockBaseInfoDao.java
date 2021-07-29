package com.tianjian.property.management.dao;

import com.tianjian.property.bean.LockBaseInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
@Repository
public interface LockBaseInfoDao {
    @Select({"<script>" +
            " SELECT lock_mac " +
            "FROM tj_lockbaseinfo WHERE id = #{id} AND 1 = 1"+
            "</script>"})
    String findById(Integer id);
    @Insert({"<script>" +
            " INSERT INTO tj_lockbaseinfo" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='lockid != null'>lock_id ,</if> " +
            " <if test='locktag != null'>lock_tag ,</if> " +
            " <if test='lockmac != null'>lock_mac ,</if> " +
            " <if test='hardwareversion != null'>hardwareversion ,</if> " +
            " <if test='softwareversion != null'>softwareversion ,</if> " +
            " <if test='locktype != null'>lock_type ,</if> " +
            " <if test='initstatus != null'>initstatus ,</if> " +
            " <if test='maxvolume != null'>maxvolume ,</if> " +
            " <if test='maxuser != null'>maxuser ,</if> " +
            " <if test='bleprotocolver != null'>bleprotocolver ,</if> " +
            " <if test='rfmoduletype != null'>rfmoduletype ,</if> " +
            " <if test='rfmodulemac != null'>rfmodulemac ,</if> " +
            " <if test='createtime != null'>createtime ,</if> " +
            " <if test='updatetime != null'>updatetime ,</if> " +
            " <if test='addpeople != null'>addpeople ,</if> " +
            " <if test='vendor != null'>vendor ,</if> " +
            " <if test='status != null'>status ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='lockid  != null'> #{lockid}, </if> " +
            " <if test='locktag  != null'> #{locktag}, </if>" +
            " <if test='lockmac  != null'> #{lockmac},</if> " +
            " <if test='hardwareversion   != null'>#{hardwareversion}, </if> " +
            " <if test='softwareversion  != null'>#{softwareversion} ,</if> " +
            " <if test='locktype != null'>#{locktype} ,</if> " +
            " <if test='initstatus  != null'>#{initstatus} ,</if> " +
            " <if test='maxvolume != null'> #{maxvolume} ,</if> " +
            " <if test='maxuser != null'> #{maxuser} ,</if> " +
            " <if test='bleprotocolver != null'> #{bleprotocolver} ,</if> " +
            " <if test='rfmoduletype != null'> #{rfmoduletype} ,</if> " +
            " <if test='rfmodulemac != null'> #{rfmodulemac} ,</if> " +
            " <if test='createtime != null'> #{createtime} ,</if> " +
            " <if test='updatetime != null'> #{updatetime} ,</if> " +
            " <if test='addpeople != null'> #{addpeople} ,</if> " +
            " <if test='vendor != null'> #{vendor} ,</if> " +
            " <if test='status != null'> #{status} ,</if> " +
            " <if test='remark != null'> #{remark} ,</if> " +
            "</trim>"+
            "</script>"})
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void inster(LockBaseInfo lockBaseInfo);
    @Select({"SELECT" +
            " id,lock_id,lock_tag,lock_mac, a.`status` ,door_id,property_name,num_name,buliding_name,unit_name,room_no,door_name , property_id " +
            "FROM " +
            " tj_lockbaseinfo a " +
            " LEFT JOIN ( " +
            " SELECT " +
            " door_id, " +
            " lock_status, " +
            " lock_facility_id, " +
            " Lock_gateway_id, " +
            " property_id, " +
            " property_name, " +
            " num_id, " +
            " num_name, " +
            " buliding_id, " +
            " buliding_name, " +
            " unit_no, " +
            " unit_name, " +
            " floor_no, " +
            " room_no, " +
            " door_name, " +
            " door_type, " +
            "  `status`  " +
            " FROM " +
            "  tj_lock l " +
            "  LEFT JOIN tj_door d ON l.door_id = d.id   " +
            " ) b ON a.id = b.lock_facility_id  " +
            "WHERE a.status != 2  AND property_id = #{propertyId} " +
            "ORDER  BY buliding_name DESC ,unit_name DESC ,room_no DESC  "})
    List<LinkedHashMap<String, Object>> selectByPropertyId(Integer propertyId);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_lockbaseinfo WHERE id = #{equipmentId} "+
            "</script>"})
    LockBaseInfo selectById(Integer equipmentId);
    @Update({"UPDATE tj_lockbaseinfo SET `status`= #{status} WHERE id = #{bluetoothLockId}"})
    void updateStatus(Integer bluetoothLockId,Integer status);
    @Select({"SELECT" +
            " id,lock_id,lock_tag,lock_mac, a.`status` ,door_id,property_name,num_name,buliding_name,unit_name,room_no,door_name , property_id " +
            "FROM " +
            " tj_lockbaseinfo a " +
            " LEFT JOIN ( " +
            " SELECT " +
            " door_id, " +
            " lock_status, " +
            " lock_facility_id, " +
            " Lock_gateway_id, " +
            " property_id, " +
            " property_name, " +
            " num_id, " +
            " num_name, " +
            " buliding_id, " +
            " buliding_name, " +
            " unit_no, " +
            " unit_name, " +
            " floor_no, " +
            " room_no, " +
            " door_name, " +
            " door_type, " +
            "  `status`  " +
            " FROM " +
            "  tj_lock l " +
            "  LEFT JOIN tj_door d ON l.door_id = d.id   " +
            " ) b ON a.id = b.lock_facility_id  " +
            "WHERE lock_tag LIKE #{keyWord} OR lock_mac LIKE #{keyWord} OR lock_id LIKE #{keyWord} AND a.`status` != 2  AND property_id = #{propertyId}   " +
            "ORDER  BY buliding_name DESC ,unit_name DESC ,room_no DESC  "})
    List<LinkedHashMap<String, Object>> fuzzySearch(Integer propertyId,String keyWord);
}
