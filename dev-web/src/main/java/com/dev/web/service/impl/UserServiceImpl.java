package com.dev.web.service.impl;

import com.dev.web.entity.User;
import com.dev.web.mapper.UserMapper;
import com.dev.web.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2018-10-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
