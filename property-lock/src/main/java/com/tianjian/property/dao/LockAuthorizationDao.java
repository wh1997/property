package com.tianjian.property.dao;

import com.tianjian.property.bean.LockAuthorization;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LockAuthorizationDao extends BaseDao<LockAuthorization> {
}