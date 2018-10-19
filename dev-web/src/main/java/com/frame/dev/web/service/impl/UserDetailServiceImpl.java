package com.frame.dev.web.service.impl;

import com.frame.dev.web.service.IUserDetailService;
import com.frame.dev.web.entity.UserDetail;
import com.frame.dev.web.mapper.UserDetailMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2018-10-19
 */
@Service
public class UserDetailServiceImpl extends ServiceImpl<UserDetailMapper, UserDetail> implements IUserDetailService {

}
