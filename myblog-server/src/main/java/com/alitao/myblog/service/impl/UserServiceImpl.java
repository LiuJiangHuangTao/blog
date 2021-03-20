package com.alitao.myblog.service.impl;

import com.alitao.myblog.entity.User;
import com.alitao.myblog.mapper.UserMapper;
import com.alitao.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author alitao
 * @since 2021-03-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
