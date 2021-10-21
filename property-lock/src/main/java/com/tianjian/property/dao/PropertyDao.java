package com.tianjian.property.dao;

import com.tianjian.property.bean.Property;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/7/5
 */
@Mapper
@Repository
public interface PropertyDao extends BaseDao<Property> {
    @Select({"<script>" +
            " SELECT id,bw_property_id,tj_oldProperty_id,property_name,branch_id,remark " +
            " FROM tj_property WHERE status=0 "+
            "</script>"})
    List<Property> selectByuserId(Integer appUID);
    @Select({"<script>" +
            " SELECT  tj_oldProperty_id" +
            " FROM tj_property WHERE bw_property_id = #{pid}"+
            "</script>"})
    Integer selectByPropertyId(Integer pid);
}
