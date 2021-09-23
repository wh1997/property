package com.tianjian.property.management.dao;

import com.tianjian.property.bean.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @description:
 * @author: ManolinCoder
 * @time: 2021/6/7
 */
@Mapper
@Repository
public interface RoleDao {
    @Insert({"<script>" +
            " INSERT INTO tj_role" +
            "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='userId != null'>user_id ,</if> " +
            " <if test='role != null'>role ,</if> " +
            " <if test='propertyId != null'>property_id ,</if> " +
            " <if test='addTime != null'>addtime ,</if> " +
            " <if test='updateTime != null'>updatetime ,</if> " +
            " <if test='remark != null'>remark </if> " +
            "</trim>"+
            "<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">"+
            " <if test='userId  != null'> #{userId}, </if> " +
            " <if test='role  != null'> #{role}, </if>" +
            " <if test='propertyId  != null'> #{propertyId},</if> " +
            " <if test='addTime   != null'>#{addTime}, </if> " +
            " <if test='updateTime  != null'>#{updateTime} ,</if> " +
            " <if test='remark != null'>#{remark} </if> " +
            "</trim>"+
            "</script>"})
    int insert(Role role);
    @Select({"<script>" +
            " SELECT role ,property_id " +
            "FROM tj_role WHERE user_id = #{userId} AND 1 = 1"+
            "</script>"})
    Map selectByUserId(Integer userId);
}
