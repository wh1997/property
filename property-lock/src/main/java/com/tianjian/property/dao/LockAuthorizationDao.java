package com.tianjian.property.dao;

import com.tianjian.property.bean.LockAuthorization;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LockAuthorizationDao extends BaseDao<LockAuthorization> {
    @Update({"<script>" +
            "UPDATE tj_lock_authorization  SET user_status =1  WHERE id=#{aId}"+
            "</script>"})
    int updateStatus(Integer aId);
}