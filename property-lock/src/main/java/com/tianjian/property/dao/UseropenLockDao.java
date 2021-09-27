package com.tianjian.property.dao;

import com.tianjian.property.bean.UseropenLock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UseropenLockDao extends BaseDao<UseropenLock> {
}