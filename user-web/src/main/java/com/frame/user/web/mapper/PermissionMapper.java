package com.frame.user.web.mapper;

import com.frame.user.web.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author derrick
 * @since 2019-03-01
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    /**
     * 根据角色id查询权限信息
     */
    List<Permission> getPermissionByRoleId(@Param("roleId") Long id);
}
