package com.tianjian.property.dao;

import com.tianjian.property.bean.LockBaseInfo;
import com.tianjian.property.dao.BaseDao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
@Repository
public interface LockBaseInfoDao extends BaseDao<LockBaseInfo> {
    @Select({"<script>" +
            " SELECT lock_mac " +
            "FROM tj_lockbaseinfo WHERE id = #{id} AND 1 = 1"+
            "</script>"})
    String findById(Integer id);
    @Insert({"<script>" +
            " INSERT INTO tj_lockbaseinfo" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='lockId != null'>lock_id ,</if> " +
            " <if test='lockTag != null'>lock_tag ,</if> " +
            " <if test='lockMac != null'>lock_mac ,</if> " +
            " <if test='hardwareVersion != null'>hardwareversion ,</if> " +
            " <if test='softwareVersion != null'>softwareversion ,</if> " +
            " <if test='lockType != null'>lock_type ,</if> " +
            " <if test='initStatus != null'>initstatus ,</if> " +
            " <if test='maxVolume != null'>maxvolume ,</if> " +
            " <if test='maxUser != null'>maxuser ,</if> " +
            " <if test='bleproTocolver != null'>bleprotocolver ,</if> " +
            " <if test='rfmoduleType != null'>rfmoduletype ,</if> " +
            " <if test='rfmoduleMac != null'>rfmodulemac ,</if> " +
            " <if test='createTime != null'>createtime ,</if> " +
            " <if test='updateTime != null'>updatetime ,</if> " +
            " <if test='addPeople != null'>addpeople ,</if> " +
            " <if test='vendor != null'>vendor ,</if> " +
            " <if test='status != null'>status ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='lockId  != null'> #{lockId}, </if> " +
            " <if test='lockTag  != null'> #{lockTag}, </if>" +
            " <if test='lockMac  != null'> #{lockMac},</if> " +
            " <if test='hardwareVersion   != null'>#{hardwareVersion}, </if> " +
            " <if test='softwareVersion  != null'>#{softwareVersion} ,</if> " +
            " <if test='lockType != null'>#{lockType} ,</if> " +
            " <if test='initStatus  != null'>#{initStatus} ,</if> " +
            " <if test='maxVolume != null'> #{maxVolume} ,</if> " +
            " <if test='maxUser != null'> #{maxUser} ,</if> " +
            " <if test='bleproTocolver != null'> #{bleproTocolver} ,</if> " +
            " <if test='rfmoduleType != null'> #{rfmoduleType} ,</if> " +
            " <if test='rfmoduleMac != null'> #{rfmoduleMac} ,</if> " +
            " <if test='createTime != null'> #{createTime} ,</if> " +
            " <if test='updateTime != null'> #{updateTime} ,</if> " +
            " <if test='addPeople != null'> #{addPeople} ,</if> " +
            " <if test='vendor != null'> #{vendor} ,</if> " +
            " <if test='status != null'> #{status} ,</if> " +
            " <if test='remark != null'> #{remark} ,</if> " +
            "</trim>"+
            "</script>"})
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void inster(LockBaseInfo lockBaseInfo);
    @Select({"SELECT" +
            " id,lock_id lockId,lock_tag lockTag,lock_mac lockMac, a.`status` ,door_id doorId,property_name propertyName," +
            " num_name numName,building_name buildingName,unit_name unitName,room_no roomNo,door_name doorName, property_id propertyId" +
            " FROM " +
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
            " building_id, " +
            " building_name, " +
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
            "ORDER  BY building_name DESC ,unit_name DESC ,room_no DESC  "})
    List<LinkedHashMap<String, Object>> selectByPropertyId(Integer propertyId);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_lockbaseinfo WHERE id = #{equipmentId} "+
            "</script>"})
    LockBaseInfo selectById(Integer equipmentId);
    @Update({"UPDATE tj_lockbaseinfo SET `status`= #{status} WHERE id = #{bluetoothLockId}"})
    void updateStatus(Integer bluetoothLockId,Integer status);
    @Select({"SELECT" +
            " id,lock_id,lock_tag,lock_mac, a.`status` ,door_id,property_name,num_name,building_name,unit_name,room_no,door_name , property_id " +
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
            " building_id, " +
            " building_name, " +
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
            "ORDER  BY building_name DESC ,unit_name DESC ,room_no DESC  "})
    List<LinkedHashMap<String, Object>> fuzzySearch(Integer propertyId,String keyWord);
}
