package com.hand.mapper;

import com.hand.model.UserDemo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author WangPan
 * @title UserDemoMapper
 * @description (描述此类的功能)
 * @date: 2018/4/25 9:54
 */
@Mapper
public interface UserDemoMapper {
    @Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
    @Results({
            @Result(id=true,property="userId",column="user_id"),
            @Result(property="userName",column="user_name"),
            @Result(property="password",column="password"),
            @Result(property="phone",column="phone")
    })
    UserDemo findUserByPhone(@Param("phone") String phone);

    @Insert("INSERT INTO T_USER(USER_NAME, PASSWORD, PHONE) VALUES(#{userName}, #{password}, #{phone})")
    int insert(@Param("userName") String userName, @Param("password") String password, @Param("phone") String phone);

}
