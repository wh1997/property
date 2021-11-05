package com.tianjian.property.dao;

import com.tianjian.property.bean.User;
import com.tianjian.property.bean.vo.DoorVo;
import org.apache.ibatis.annotations.Insert;
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
    @Insert({"<script>" +
            " INSERT INTO tj_user" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='userId != null'>user_id ,</if> " +
            " <if test='role != null'>role ,</if> " +
            " <if test='phone != null'>phone ,</if> " +
            " <if test='name != null'>name ,</if> " +
            " <if test='addTime != null'>add_time ,</if> " +
            " <if test='updateTime != null'>update_time ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='userId  != null'> #{userId}, </if> " +
            " <if test='role  != null'> #{role}, </if>" +
            " <if test='phone != null'> #{phone},</if> " +
            " <if test='name != null'> #{name},</if> " +
            " <if test='addTime   != null'>#{addTime}, </if> " +
            " <if test='updateTime  != null'>#{updateTime} ,</if> " +
            " <if test='remark != null'>#{remark} </if> " +
            "</trim>"+
            "</script>"})
    int insert(User role);
    @Select({"<script>" +
            "SELECT role_id  FROM  `tj_user` u " +
            " INNER JOIN  tj_user_role r ON u.user_id = r.user_id " +
            " WHERE u.user_id " +
            " = #{userId}" +
            "</script>"})
    List<Integer> selectRoleByUserId(Integer userId);
}