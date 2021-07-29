package com.tianjian.property.management.dao;

import com.tianjian.property.bean.BaiWeiId;
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
public interface BaiWeiIdDao {
    @Select({"<script>" +
            " SELECT id,bw_property_id,tj_oldProperty_id,property_name,remark " +
            "FROM tj_baiwei_old_id"+
            "</script>"})
    List<BaiWeiId> selectAll();
}
