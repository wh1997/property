package com.tianjian.property.dao;

import com.tianjian.property.bean.DoorType;
import com.tianjian.property.bean.Fingerprint;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FingerprintDao extends  BaseDao<Fingerprint> {
    @Select({"<script>" +
            " SELECT * " +
            " FROM tj_fingerprint WHERE (validend_time <![CDATA[ >= ]]> unix_timestamp( now()) OR validend_time =0 ) " +
            " AND door_id = #{doorId} AND add_person= #{addPerson} AND status = 0 "+
            "</script>"})
    List<Fingerprint> selectByuser(Integer doorId, Integer addPerson);
    @Update({"<script>" +
            "UPDATE tj_fingerprint " +
            "SET status = 1" +
            " WHERE door_id = #{doorId}  AND lockKey_id =#{lockKeyId}" +
            "</script>"})
    int updateStatus(Integer doorId,Integer lockKeyId);
}