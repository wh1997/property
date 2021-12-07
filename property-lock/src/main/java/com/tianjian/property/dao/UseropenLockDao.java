package com.tianjian.property.dao;

import com.tianjian.property.bean.UseropenLock;
import jdk.nashorn.internal.objects.annotations.Optimistic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UseropenLockDao extends BaseDao<UseropenLock> {
    @Select({"<script>" +
            "SELECT * " +
            "FROM  " +
            " `tj_useropen_lock` u  " +
            "WHERE  " +
            " ( u.validend_time <![CDATA[ >= ]]> unix_timestamp( now()) OR u.validend_time IS NULL ) AND status= 0 AND door_id = #{doorId} " +
            "</script>"})
    UseropenLock selectPassword(Integer doorId);
//    @Select({"<script>" +
//            "SELECT  " +
//            " u.*   " +
//            " d.id dId,  " +
//            " d.property_id propertyId,  " +
//            " d.property_name propertyName,  " +
//            " d.num_name numName,  " +
//            " d.building_name buildingName,  " +
//            " d.unit_name unitName,  " +
//            " d.floor_no floorNo,  " +
//            " d.room_no roomNo,  " +
//            " d.door_name doorName,  " +
//            " d.door_type doorType,  " +
//            " d.status dStatus "+
//            "FROM  " +
//            " `tj_useropen_lock` u  " +
//            " INNER JOIN tj_door d ON u.door_id = d.id   " +
//            "WHERE  " +
//            " ( u.validend_time <![CDATA[ <= ]]>  CURDATE() OR u.validend_time IS NULL ) AND d.id = #{doorId} " +
//            "ORDER BY  " +
//            " property_id ASC,  " +
//            " building_id ASC,  " +
//            " num_id ASC,  " +
//            " unit_no ASC,  " +
//            " floor_no ASC,  " +
//            " room_no ASC"+
//            "</script>"})
//    Map<String,Object> selectPassword(Integer doorId);
    @Update({"<script>" +
            "UPDATE tj_useropen_lock " +
            "SET status = 1" +
            " WHERE door_id= #{doorId} " +
            " AND lock_id= #{lockId} " +
            " AND keyContent" +
            "= #{keyContent} " +
            "</script>"})
    int deletePassword(Integer doorId, String lockId, String keyContent);
    @Update({"<script>" +
            "UPDATE tj_useropen_lock " +
            "SET status = 1" +
            " WHERE door_id= #{doorID} " +
            "</script>"})
    int updateStatus(Integer doorId);
    @Select({"<script>" +
            "SELECT * " +
            "FROM  " +
            " `tj_useropen_lock` u  " +
            "WHERE  " +
            " lock_id = #{lockId} " +
            "</script>"})
    UseropenLock selectLockId(String lockId);
    @Insert({"<script>" +
            " INSERT INTO tj_useropen_lock" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorId != null'>door_id ,</if> " +
            " <if test='lockId != null'>lock_id ,</if> " +
            " <if test='lockUserId != null'>lock_user_id ,</if> " +
            " <if test='keyContent != null'>keyContent ,</if> " +
            " <if test='validstartTime != null'>validstart_time ,</if> " +
            " <if test='validendTime != null'>validend_time ,</if> " +
            " <if test='addTime != null'>add_time ,</if> " +
            " <if test='updateTime != null'>update_time ,</if> " +
            " <if test='addPerson != null'>add_person ,</if> " +
            " <if test='status != null'>status ,</if> " +
            " <if test='remark != null'>remark ,</if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='doorId  != null'> #{doorId}, </if> " +
            " <if test='lockId  != null'> #{lockId}, </if>" +
            " <if test='lockUserId  != null'> #{lockUserId},</if> " +
            " <if test='keyContent != null'>#{keyContent}, </if> " +
            " <if test='validstartTime  != null'>#{validstartTime} ,</if> " +
            " <if test='validendTime != null'>#{validendTime} ,</if> " +
            " <if test='addTime  != null'>#{addTime} ,</if> " +
            " <if test='updateTime != null'> #{updateTime} ,</if> " +
            " <if test='addPerson != null'> #{addPerson} ,</if> " +
            " <if test='status != null'> #{status} ,</if> " +
            " <if test='remark != null'> #{remark} ,</if> " +
            "</trim>"+
            "</script>"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insertUseropenLock(UseropenLock useropenLock);
}