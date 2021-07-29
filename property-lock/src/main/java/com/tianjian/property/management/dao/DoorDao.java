package com.tianjian.property.management.dao;

import com.tianjian.property.bean.Door;
import com.tianjian.property.bean.vo.DoorVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DoorDao {
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,buliding_id,buliding_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE property_id = #{propertyid}   GROUP　BY　　" +
            "</script>"})
    List<DoorVo> selectall(Integer propertyid);
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,buliding_id,buliding_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'> property_id = #{propertyid} </if> " +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if> " +
            "</script>"})
    List<DoorVo> RoomnoAndPropertyname(Integer propertyid,String roomno);
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,buliding_id,buliding_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'>  property_id = #{propertyid} </if>" +
            "<if test='bulidingid !=null'> AND buliding_id = #{bulidingid} </if>" +
            "<if test='unitname !=null'>AND unit_name = #{unitname} </if>" +
            "</script>"})
    List<DoorVo> screenRoomDoor(Integer propertyid, Integer bulidingid, String unitname);
    //添加公共门
   @Insert({"<script>" +
           " INSERT INTO tj_door" +
           "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='propertyid != null'>property_id ,</if> " +
           " <if test='propertyname != null'>property_name ,</if> " +
           " <if test='numid != null'>num_id ,</if> " +
           " <if test='numname != null'>num_name ,</if> " +
           " <if test='bulidingid != null'>buliding_id ,</if> " +
           " <if test='bulidingname != null'>buliding_name ,</if> " +
           " <if test='unitno != null'>unit_no ,</if> " +
           " <if test='unitname != null'>unit_name ,</if> " +
           " <if test='floorno != null'> floor_no ,</if> " +
           " <if test='roomno != null'> room_no ,</if> " +
           " <if test='doortype != null'>door_type ,</if> " +
           " <if test='doorname != null'>door_name ,</if> " +
           " <if test='addtime != null'>addtime ,</if> " +
           " <if test='status != null'>status ,</if> " +
           " <if test='createperson != null'>create_person ,</if> " +
           " <if test='remark != null'>remark </if> " +
           "</trim>"+
           "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
           " <if test='propertyid  != null'>#{propertyid} ,</if> " +
           " <if test='propertyname != null'>#{propertyname} ,</if> " +
           " <if test='numid  != null'>#{numid} ,</if> " +
           " <if test='numname != null'> #{numname} ,</if> " +
           " <if test='bulidingid != null'> #{bulidingid} ,</if> " +
           " <if test='bulidingname != null'> #{bulidingname} ,</if> " +
           " <if test='unitno != null'> #{unitno} ,</if> " +
           " <if test='unitname != null'> #{unitname} ,</if> " +
           " <if test='floorno != null'> #{floorno} ,</if> " +
           " <if test='roomno != null'> #{roomno} ,</if> " +
           " <if test='doortype != null'> #{doortype} ,</if> " +
           " <if test='doorname != null'> #{doorname} ,</if> " +
           " <if test='addtime != null'> #{addtime} ,</if> " +
           " <if test='status != null'> #{status} ,</if> " +
           " <if test='createperson != null'> #{createperson} ,</if> " +
           " <if test='remark != null'> #{remark} </if> " +
           "</trim>"+
           "</script>"})
   int insert(Door door);
    @Select({"<script>" +
            " SELECT id  " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'> property_id = #{propertyid} </if>" +
            "<if test='numid !=null'>AND num_id = #{numid} </if>" +
            "<if test='bulidingid !=null'>AND buliding_id = #{bulidingid} </if>" +
            "<if test='unitno !=null'>AND unit_no = #{unitno} </if>" +
            "<if test='unitname !=null'>AND unit_name = #{unitname} </if>" +
            "<if test='floorno !=null'>AND floor_no = #{floorno} </if>" +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if>" +
            "</script>"})
   Integer selectRepetition(Door door);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'> property_id = #{propertyid} </if>" +
            "<if test='doortype !=null'>AND door_type = #{doortype} </if>" +
            "</script>"})
    List<Door> selectCommonDoor( Integer propertyid, Integer doortype);
    //根据楼栋分组查出该楼栋下有哪些楼栋
    @Select({"<script>" +
            " SELECT buliding_name " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'>  property_id = #{propertyid} </if>" +
            "<if test='doortype !=null'>AND door_type = #{doortype} </if>" +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if>" +
            " GROUP   BY buliding_name"+
            "</script>"})
    List<String> selectBulidingid( Integer propertyid, Integer doortype,String roomno);
    //根据楼栋分组查出该楼栋下有哪些单元
    @Select({"<script>" +
            " SELECT unit_name " +
            "FROM tj_door WHERE " +
            "<if test='propertyid !=null'> property_id = #{propertyid} </if>" +
            "<if test='bulidingname !=null'>AND buliding_name = #{bulidingname} </if>" +
            "<if test='roomno !=null'>AND room_no = #{roomno} </if>" +
            "AND 1 = 1 GROUP   BY unit_name ORDER BY unit_name"+
            "</script>"})
    List<String> selectunitname(Integer propertyid,String bulidingname,String roomno);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE " +
            "property_name LIKE #{doorName} OR " +
            "buliding_name LIKE #{doorName} OR " +
            "num_name LIKE #{doorName} OR " +
            "unit_name LIKE #{doorName} OR " +
            "door_name LIKE #{doorName}  " +
            "AND door_type = #{doorType} ORDER BY door_name desc,unit_name desc,buliding_name desc "+
            "</script>"})
    List<Door> fuzzyQueryCommonDoor(String doorName, Integer doorType);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_door WHERE " +
            "property_name LIKE #{fuzzy} OR " +
            "buliding_name LIKE #{fuzzy} OR " +
            "unit_name LIKE #{fuzzy} OR " +
            "room_no LIKE #{fuzzy} OR " +
            "door_name LIKE #{fuzzy}  " +
            "AND door_type = 3 AND property_id = #{propertyid}  ORDER BY room_no desc,unit_name desc,buliding_name desc ,floor_no desc"+
            "</script>"})
    List<Door> fuzzySearch(Integer  propertyid,String fuzzy);
   @Insert({"<script>" +
           " INSERT INTO tj_door" +
           "(property_id ,property_name,num_id,num_name,buliding_id,buliding_name,unit_no,unit_name,floor_no,room_no,door_name," +
           "door_type,status,addtime,updatetime,create_person,remark) values "+
           " <foreach collection=\"list\" item=\"door\" index=\"index\"  separator=\",\"> " +
           "(#{door.propertyid},#{door.propertyname},#{door.numid},#{door.numname},#{door.bulidingid}" +
           ",#{door.bulidingname},#{door.unitno},#{door.unitname},#{door.floorno},#{door.roomno}" +
           ",#{door.doorname},#{door.doortype},#{door.status},#{door.addtime},#{door.updatetime}" +
           ",#{door.createperson},#{door.remark})" +
           "</foreach>"+
           "</script>"})
    void addDoor(List<Door> list);
    @Select({"SELECT * FROM  tj_door  WHERE id = #{doorID}"})
    Door selectById(Integer doorID);
}
