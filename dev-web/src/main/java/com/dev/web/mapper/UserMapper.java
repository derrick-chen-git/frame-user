package com.dev.web.mapper;

import com.dev.web.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
