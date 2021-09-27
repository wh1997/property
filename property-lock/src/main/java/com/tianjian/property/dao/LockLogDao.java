package com.tianjian.property.dao;

import com.tianjian.property.bean.LockLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LockLogDao extends BaseDao<LockLog> {
}