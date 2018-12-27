package com.example.springsecuritydemo2.controller;

import com.example.springsecuritydemo2.entity.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/role")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') or hasAnyAuthority('ROLE_HOME')")
    public String role() {
        return "role";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/rest")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String rest() {
        SysUser user = new SysUser();
        return "admin/admin";
    }
}
