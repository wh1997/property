package com.tianjian.property.dao;

import com.tianjian.property.bean.User;
import com.tianjian.property.bean.vo.DoorVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao extends BaseDao<User> {
    @Select({"<script>" +
            " SELECT u.id ,u.user_id,u.role,r.id rId, r.parent_id,r.name,r.sort,r.status" +
            " FROM `tj_user` u LEFT JOIN tj_user_role t ON u.user_id= t.user_id " +
            "LEFT JOIN tj_role r ON t.role_id=r.id  WHERE u.user_id= #{appUID}" +
            "</script>"})
    List<Map<String,Object>> selectUserByRole(Integer  appUID);
}