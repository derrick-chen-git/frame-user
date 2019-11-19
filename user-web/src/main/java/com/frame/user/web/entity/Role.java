package com.frame.user.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author derrick
 * @since 2019-03-01
 */
@TableName("t_role")
@ApiModel(value="Role对象", description="")
@Data
@Builder
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "注释")
    private String remark;

    @ApiModelProperty(value = "删除标识")
    private Boolean isDelete;



    private LocalDateTime createdAt;

    private LocalDateTime updateAt;
    //角色的相关权限
    private List<Permission> permissions;

}
