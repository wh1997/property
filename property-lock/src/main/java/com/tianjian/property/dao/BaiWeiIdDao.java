package com.tianjian.property.dao;

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
public interface BaiWeiIdDao extends BaseDao<BaiWeiId> {
    @Select({"<script>" +
            " SELECT id,bw_property_id,tj_oldProperty_id,property_name,branch_id,remark " +
            " FROM tj_baiwei_old_id WHERE status=0 "+
            "</script>"})
    List<BaiWeiId> selectAll();
    @Select({"<script>" +
            " SELECT tj_oldProperty_id " +
            " FROM tj_baiwei_old_id WHERE bw_property_id = #{pid}"+
            "</script>"})
    Integer selectByPropertyId(Integer pid);
}
