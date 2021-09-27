package com.tianjian.property.dao;

import com.tianjian.property.bean.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleDao extends BaseDao<UserRole> {
}