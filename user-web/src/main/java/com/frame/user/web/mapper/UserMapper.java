package com.frame.user.web.mapper;

import com.frame.user.web.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2019-03-01
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByName(@Param("name") String name);
}
