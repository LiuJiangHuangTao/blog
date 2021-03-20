package com.alitao.myblog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.alitao.myblog.common.Result;
import com.alitao.myblog.entity.User;
import com.alitao.myblog.service.UserService;
import com.alitao.myblog.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login( @Validated @RequestBody User u, HttpServletResponse response) {
        //校验用户名
        User user = userService.getOne(new QueryWrapper<User>().eq("username", u.getUsername()));
        if(user==null){
            return Result.fail("用户不存在");
        }
        //密码加盐

        String  password="alitao"+u.getPassword()+"lj";
        //校验密码
        if(!user.getPassword().equals(SecureUtil.md5(password))){
            return Result.fail("密码不正确");
        }
        //jwtUtils工具类生成jwt
        String jwt = jwtUtils.generateToken(user.getId());
        //设置响应头
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("nickname", user.getNickname())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

}
