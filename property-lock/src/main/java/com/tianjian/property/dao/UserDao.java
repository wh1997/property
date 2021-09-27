package com.tianjian.property.dao;

import com.tianjian.property.bean.User;
import com.tianjian.property.bean.vo.DoorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao extends BaseDao<User> {
    @Select({"<script>" +
            " SELECT id ,num_id,num_name,building_id,building_name,floor_no ,room_no,door_name,status ,unit_no ,unit_name " +

            "</script>"})
    List<DoorVo> selectUserByRole(Integer  appUID);
}