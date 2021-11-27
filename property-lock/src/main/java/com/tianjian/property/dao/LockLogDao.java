package com.tianjian.property.dao;

import com.tianjian.property.bean.LockLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LockLogDao extends BaseDao<LockLog> {
    @Select({"<script>" +
            " SELECT *  " +
            "FROM tj_lock_log WHERE  1=1  "+
            "<if test='lockLog != null'> " +
            "<if test='lockLog.id != null'> AND id = #{lockLog.id}</if>" +
            "<if test='lockLog.doorId != null'> AND door_id = #{lockLog.doorId}</if>" +
            "<if test='lockLog.lockType != null'> AND lock_type = #{lockLog.lockType}</if>" +
            "<if test='lockLog.lockMac != null'> AND lock_mac  like CONCAT('%',#{lockLog.lockMac},'%')</if>" +
            "<if test='lockLog.recordTime != null'> AND record_time <![CDATA[ >= ]]> #{lockLog.recordTime}</if>" +
            "<if test='lockLog.propertyId != null'> AND property_id  = #{lockLog.propertyId}</if>" +
            "<if test='lockLog.userId != null'> AND user_id  = #{lockLog.userId}</if>" +
            "<if test='lockLog.addTime != null'> AND add_time  <![CDATA[ >= ]]> #{lockLog.addTime}</if>" +
            "<if test='lockLog.status != null'> AND status  = #{lockLog.status}</if>" +
            "</if>" +
            "ORDER BY record_time DESC"+
            "</script>"})
    List<LockLog> openLockLog(@Param("lockLog") LockLog lockLog);
}