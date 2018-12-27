package com.example.springsecuritydemo2.dao;

import com.example.springsecuritydemo2.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> findAll();

    List<Permission> findByAdminUserId(int userId);
}
