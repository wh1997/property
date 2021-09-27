package com.tianjian.property.dao;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.vo.DoorVo;
import com.tianjian.property.dao.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DoorDao extends BaseDao<Door> {
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,building_id,building_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE 1=1 " +
            "<if test='door != null'> " +
            "<if test='door.id != null'> AND id = #{door.id}</if>" +
            "<if test='door.propertyId != null'> AND property_id = #{door.propertyId}</if>" +
            "<if test='door.propertyName != null'> AND property_name  like CONCAT('%',#{door.propertyName},'%')</if>" +
            "<if test='door.numId != null'> AND num_id = #{door.numId}</if>" +
            "<if test='door.numName != null'> AND num_name like CONCAT('%',#{door.numName},'%') </if>" +
            "<if test='door.buildingId != null'> AND building_id = #{door.buildingId}</if>" +
            "<if test='door.buildingName != null'> AND building_name like CONCAT('%',#{door.buildingName},'%') </if>" +
            "<if test='door.unitNo != null'> AND unit_no = #{door.unitNo}</if>" +
            "<if test='door.unitName != null'> AND unit_name like CONCAT('%',#{door.unitName},'%') </if>" +
            "<if test='door.floorNo != null'> AND floor_no = #{door.floorNo}</if>" +
            "<if test='door.roomNo != null'> AND room_no = #{door.roomNo}</if>" +
            "<if test='door.doorName != null'> AND door_name like CONCAT('%',#{door.doorName},'%')</if>" +
            "<if test='door.doorType != null'> AND door_type =  #{door.doorType}</if>" +
            "<if test='door.status != null'> AND status = #{door.status}</if>" +
            "<if test='door.addTime != null'> AND addtime = #{door.addTime}</if>" +
            "<if test='door.updateTime != null'> AND updatetime = #{door.updateTime}</if>" +
            "<if test='door.createPerson != null'> AND create_person = #{door.createPerson}</if>" +
            "<if test='door.remark != null'> AND remark = #{door.remark}</if>" +
            "</if>" +
            "ORDER  BY property_id ASC ,building_id ASC ,num_id ASC,unit_no ASC ,floor_no ASC"+
            "</script>"})
    List<DoorVo> selectall(@Param("door") Door door);
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,building_id,building_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE 1=1 " +
            "<if test='propertyid !=null'>AND property_id = #{propertyid} </if> " +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if> " +
            "</script>"})
    List<DoorVo> RoomnoAndPropertyname(Integer propertyid,String roomno);
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,building_id,building_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE 1=1" +
            "<if test='propertyid !=null'> AND property_id = #{propertyid} </if>" +
            "<if test='buildingid !=null'> AND building_id = #{buildingid} </if>" +
            "<if test='unitname !=null'>AND unit_name = #{unitname} </if>" +
            "</script>"})
    List<DoorVo> screenRoomDoor(Integer propertyid, Integer buildingid, String unitname);
    //添加公共门
   @Insert({"<script>" +
           " INSERT INTO tj_door" +
           "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='propertyId != null'>property_id ,</if> " +
           " <if test='propertyName != null'>property_name ,</if> " +
           " <if test='numId != null'>num_id ,</if> " +
           " <if test='numName != null'>num_name ,</if> " +
           " <if test='buildingId != null'>building_id ,</if> " +
           " <if test='buildingName != null'>building_name ,</if> " +
           " <if test='unitNo != null'>unit_no ,</if> " +
           " <if test='unitName != null'>unit_name ,</if> " +
           " <if test='floorNo != null'> floor_no ,</if> " +
           " <if test='roomNo != null'> room_no ,</if> " +
           " <if test='doorType != null'>door_type ,</if> " +
           " <if test='doorName != null'>door_name ,</if> " +
           " <if test='addTime != null'>addtime ,</if> " +
           " <if test='status != null'>status ,</if> " +
           " <if test='createPerson != null'>create_person ,</if> " +
           " <if test='remark != null'>remark </if> " +
           "</trim>"+
           "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='propertyId  != null'>#{propertyId} ,</if> " +
           " <if test='propertyName != null'>#{propertyName} ,</if> " +
           " <if test='numId  != null'>#{numId} ,</if> " +
           " <if test='numName != null'> #{numName} ,</if> " +
           " <if test='buildingId != null'> #{buildingId} ,</if> " +
           " <if test='buildingName != null'> #{buildingName} ,</if> " +
           " <if test='unitNo != null'> #{unitNo} ,</if> " +
           " <if test='unitName != null'> #{unitName} ,</if> " +
           " <if test='floorNo != null'> #{floorNo} ,</if> " +
           " <if test='roomNo != null'> #{roomNo} ,</if> " +
           " <if test='doorType != null'> #{doorType} ,</if> " +
           " <if test='doorName != null'> #{doorName} ,</if> " +
           " <if test='addTime != null'> #{addTime} ,</if> " +
           " <if test='status != null'> #{status} ,</if> " +
           " <if test='createPerson != null'> #{createPerson} ,</if> " +
           " <if test='remark != null'> #{remark} </if> " +
           "</trim>"+
           "</script>"})
   int insert(Door door);
    @Select({"<script>" +
            " SELECT id  " +
            "FROM tj_door WHERE 1=1 " +
            "<if test='propertyId !=null'>AND property_id = #{propertyId} </if>" +
            "<if test='numId !=null'>AND num_id = #{numId} </if>" +
            "<if test='buildingId !=null'>AND building_id = #{buildingId} </if>" +
            "<if test='unitNo !=null'>AND unit_no = #{unitNo} </if>" +
            "<if test='unitName !=null'>AND unit_name = #{unitName} </if>" +
            "<if test='floorNo !=null'>AND floor_no = #{floorNo} </if>" +
            "<if test='roomNo !=null'>AND room_no = #{roomNo} </if>" +
            "</script>"})
   Integer selectRepetition(Door door);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE 1=1" +
            "<if test='propertyid !=null'>AND property_id = #{propertyid} </if>" +
            "<if test='doortype !=null'>AND door_type = #{doortype} </if>" +
            "</script>"})
    List<Door> selectCommonDoor( Integer propertyid, Integer doortype);
    //根据楼栋分组查出该楼栋下有哪些楼栋
    @Select({"<script>" +
            " SELECT building_name " +
            "FROM tj_door WHERE 1=1" +
            "<if test='propertyid !=null'> AND property_id = #{propertyid} </if>" +
            "<if test='doortype !=null'>AND door_type = #{doortype} </if>" +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if>" +
            " GROUP   BY building_name"+
            "</script>"})
    List<String> selectbuildingid( Integer propertyid, Integer doortype,String roomno);
    //根据楼栋分组查出该楼栋下有哪些单元
    @Select({"<script>" +
            " SELECT unit_name " +
            "FROM tj_door WHERE 1=1 " +
            "<if test='propertyid !=null'> AND property_id = #{propertyid} </if>" +
            "<if test='buildingname !=null'>AND building_name = #{buildingname} </if>" +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if>" +
            "AND 1 = 1 GROUP   BY unit_name ORDER BY unit_name"+
            "</script>"})
    List<String> selectunitname(Integer propertyid,String buildingname,String roomno);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE " +
            "property_name LIKE #{doorName} OR " +
            "building_name LIKE #{doorName} OR " +
            "num_name LIKE #{doorName} OR " +
            "unit_name LIKE #{doorName} OR " +
            "door_name LIKE #{doorName}  " +
            "AND door_type = #{doorType} ORDER BY door_name desc,unit_name desc,building_name desc "+
            "</script>"})
    List<Door> fuzzyQueryCommonDoor(String doorName, Integer doorType);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE " +
            "property_name LIKE #{fuzzy} OR " +
            "building_name LIKE #{fuzzy} OR " +
            "unit_name LIKE #{fuzzy} OR " +
            "room_no LIKE #{fuzzy} OR " +
            "door_name LIKE #{fuzzy}  " +
            "AND door_type = 3 AND property_id = #{propertyid}  ORDER BY room_no desc,unit_name desc,building_name desc ,floor_no desc"+
            "</script>"})
    List<Door> fuzzySearch(Integer  propertyid,String fuzzy);
   @Insert({"<script>" +
           " INSERT INTO tj_door" +
           "(property_id ,property_name,num_id,num_name,building_id,building_name,unit_no,unit_name,floor_no,room_no,door_name," +
           "door_type,status,addtime,updatetime,create_person,remark) values "+
           " <foreach collection=\"list\" item=\"door\" index=\"index\"  separator=\",\"> " +
           "(#{door.propertyId},#{door.propertyName},#{door.numId},#{door.numName},#{door.buildingId}" +
           ",#{door.buildingName},#{door.unitNo},#{door.unitName},#{door.floorNo},#{door.roomNo}" +
           ",#{door.doorName},#{door.doorType},#{door.status},#{door.addTime},#{door.updateTime}" +
           ",#{door.createPerson},#{door.remark})" +
           "</foreach>"+
           "</script>"})
    void addDoor(List<Door> list);
    @Select({"SELECT * FROM  tj_door  WHERE id = #{doorID}"})
    Door selectById(Integer doorID);
}