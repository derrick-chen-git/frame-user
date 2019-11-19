package com.frame.user.web.mapper;

import com.frame.user.web.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2019-03-01
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询用户所有角色
     * @param id
     * @return
     */
    List<Role> selectRoleByUserId(Long id);

    /**
     * 根据用户id查询角色与权限
     * @param id
     * @return
     */
    List<Role> selectRoleAndPermissionsByUserId(Long id);
}
