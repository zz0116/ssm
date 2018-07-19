package com.zyz.demo.ssm.mapper;

import com.zyz.demo.ssm.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where name = #{name}")
    User getUserByName(@Param("name") String name);

    @Insert("insert into user (name, pwd) values (#{user.username}, #{user.password})")
    boolean addUser(@Param("user") User user);
}
