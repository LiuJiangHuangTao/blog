package com.alitao.myblog.controller;


import com.alitao.myblog.common.Result;
import com.alitao.myblog.entity.User;
import com.alitao.myblog.service.UserService;
import com.alitao.myblog.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author alitao
 * @since 2021-03-20
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;




}
