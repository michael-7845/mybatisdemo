package com.elements.user.mapper;

import com.elements.user.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("select * from mybatisdemo.user")
    public List<User> getAllUser();

    @Select("select * from mybatisdemo.user where userId= #{userId}")
    public User getUserById(String userId);

    @Insert("insert into mybatisdemo.user(UserName, UserEmail) values(#{UserName}, #{UserEmail})")
    public int insert(User user);

    @Update("update mybatisdemo.user set UserName=#{UserName}," +
            " UserEmail=#{UserEmail}" +
            " where userId= #{userId}")
    public int update(User user);

    @Delete("delete mybatisdemo.user where userId= #{userId}")
    public int delete(User user);
}

