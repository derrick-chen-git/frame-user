package com.dev.web.service;

import com.dev.web.entity.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
public interface IUserService extends IService<User> {
    /**
     * 根据userId查询用户信息 缓存 10分钟
     */
    User getUserById(long userId);
    /**
     * 获取所有用户
     */
    List<User> getAllUsers();
}
