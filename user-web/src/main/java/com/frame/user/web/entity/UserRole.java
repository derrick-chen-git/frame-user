package com.frame.user.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
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
@TableName("t_user_role")
@ApiModel(value="UserRole对象", description="")
@Data
@Builder
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime uodateAt;

    @ApiModelProperty(value = "删除标识")
    private Boolean isDelete;




    @Override
    public String toString() {
        return "UserRole{" +
        "id=" + id +
        ", userId=" + userId +
        ", roleId=" + roleId +
        ", createdAt=" + createdAt +
        ", uodateAt=" + uodateAt +
        ", isDelete=" + isDelete +
        "}";
    }
}
