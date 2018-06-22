package com.dev.web.service.impl;

import com.dev.web.entity.UserDetail;
import com.dev.web.mapper.UserDetailMapper;
import com.dev.web.service.IUserDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

}
