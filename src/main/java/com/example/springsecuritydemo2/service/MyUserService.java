package com.example.springsecuritydemo2.service;

import com.example.springsecuritydemo2.dao.PermissionMapper;
import com.example.springsecuritydemo2.dao.UserMapper;
import com.example.springsecuritydemo2.entity.Permission;
import com.example.springsecuritydemo2.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userMapper.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionMapper.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String password = passwordEncoder.encode(user.getPassword());
            return new User(user.getUsername(), password, grantedAuthorities);
        } else {
            logger.error(username + "不存在");
            return null;
        }
    }

}
