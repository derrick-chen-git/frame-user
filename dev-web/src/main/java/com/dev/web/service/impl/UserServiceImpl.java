package com.dev.web.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frame.common.utils.RedisUtils;
import com.dev.web.entity.User;
import com.dev.web.mapper.UserMapper;
import com.dev.web.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long userId) {
        log.info("UserServiceImpl getUserByCache method start userId:{}",userId);
        try {
            String redisKey = "UserId" + userId;
            if (redisUtils.exists(redisKey)) {
                return (User) redisUtils.get(redisKey);
            } else {
                User userParam =new User();
                userParam.setUserId(userId);
                User user = userMapper.selectOne(userParam);
                if (!Objects.isNull(user)) {
                    //设置过期时间10分钟
                    redisUtils.set(redisKey, user, TimeUnit.MINUTES.toSeconds(10));
                }
                return user;
            }
        }catch(Exception e){
            log.error("UserServiceImpl getUserByCache method errror msg:{},userId:{}",e.getMessage(),userId);
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        log.info("UserServiceImpl getAllUsers method start");
        return userMapper.selectList(new EntityWrapper<>());
    }
}
