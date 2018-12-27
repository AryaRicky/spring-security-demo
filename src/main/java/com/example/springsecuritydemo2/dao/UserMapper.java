package com.example.springsecuritydemo2.dao;

import com.example.springsecuritydemo2.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    SysUser findByUserName(String username);
}
