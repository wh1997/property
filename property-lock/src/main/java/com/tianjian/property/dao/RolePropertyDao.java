package com.tianjian.property.dao;

import com.tianjian.property.bean.RoleProperty;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RolePropertyDao extends BaseDao<RoleProperty> {
}