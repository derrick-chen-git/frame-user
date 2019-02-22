package com.frame.user.web.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.frame.common.base.ResponseData;
import com.frame.user.web.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author derrick
 * @since 2018-10-12
 */
public interface IUserService extends IService<User> {
    /**
     * 获取所有用户信息
     * @return
     */
    ResponseData<List<User>> getAllUsers();
    /**
     * 获取单个用户信息
     */
    ResponseData<User> getUserById(Long id);
    /**
     * 查询分页数据
     */
    ResponseData<IPage<User>> getUserPage(int pageNum, int pageSize);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Object insertUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    ResponseData updateUser(User user);
}
