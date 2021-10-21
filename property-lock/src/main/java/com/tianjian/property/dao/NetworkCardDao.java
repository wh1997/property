package com.tianjian.property.dao;

import com.tianjian.property.bean.NetworkCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NetworkCardDao extends BaseDao<NetworkCard> {
    @Select({"<script>" +
            " SELECT network_name,deviceflag  " +
            "FROM tj_network_card WHERE id = #{lockfacilityid}"+
            "</script>"})
    Map<String,String> selectById(Integer lockfacilityid);
    @Select({"<script>" +
            " SELECT *  " +
            "FROM tj_network_card WHERE property_id = #{propertyId}  AND network_status != 1"+
            "</script>"})
    List<NetworkCard> findByPropertyId(Integer propertyId);
    @Select({"<script>" +
            " SELECT * " +
            "FROM tj_network_card WHERE id = #{equipmentId}"+
            "</script>"})
    NetworkCard selectByIdAll(Integer equipmentId);
    @Update({"<script>"+
            "UPDATE tj_network_card SET network_status = #{status} WHERE id = #{id}"+
            "</script>"})
    void updateStatus(Integer id, Integer status);
    @Select({"<script>" +
            "SELECT " +
            " *  " +
            "FROM " +
            " tj_network_card " +
            " WHERE " +
            " network_name LIKE #{keyWord}  " +
            " OR deviceflag LIKE #{keyWord}  " +
            " AND property_id = #{propertyId}   " +
            " AND network_status != 1"+
            "</script>"})
    List<NetworkCard> fuzzySearch(Integer propertyId,String keyWord);
}
