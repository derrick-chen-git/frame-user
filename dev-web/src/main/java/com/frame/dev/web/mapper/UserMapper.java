package com.frame.dev.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frame.dev.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2018-10-12
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
