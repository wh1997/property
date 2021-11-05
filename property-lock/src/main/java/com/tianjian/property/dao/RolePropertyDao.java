package com.tianjian.property.dao;

import com.tianjian.property.bean.Property;
import com.tianjian.property.bean.RoleProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RolePropertyDao extends BaseDao<RoleProperty> {
    @Select({"<script>" +
            " SELECT p.id,p.branch_id,p.bw_property_id,p.tj_oldProperty_id,p.property_name " +
            " FROM `tj_role` r LEFT JOIN tj_role_property t ON r.id= t.role_id " +
            " LEFT JOIN tj_property p ON t.property_id=p.id  WHERE r.id IN " +
            "<foreach collection=\"lists\" item=\"list\" index=\"index\" open=\"(\" close=\")\" separator=\",\"> " +
            "#{list} " +
            "</foreach>" +
            " group by p.id "+
            "</script>"})
    List<Property> selectPropertyByRole(@Param("lists") List<Integer>  lists);
    @Select({"<script>" +
            " SELECT p.bw_property_id " +
            " FROM `tj_role` r LEFT JOIN tj_role_property t ON r.id= t.role_id " +
            " LEFT JOIN tj_property p ON t.property_id=p.id  WHERE r.id IN " +
            "<foreach collection=\"lists\" item=\"list\" index=\"index\" open=\"(\" close=\")\" separator=\",\"> " +
            "#{list} " +
            "</foreach>" +
            " group by p.id "+
            "</script>"})
    List<Integer> selectPropertyByRoleId(@Param("lists") List<Integer>  lists);
}