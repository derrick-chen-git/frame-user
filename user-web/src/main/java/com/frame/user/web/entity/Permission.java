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
@TableName("t_permission")
@ApiModel(value="Permission对象", description="")
@Data
@Builder
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "功能名称")
    private String name;

    @ApiModelProperty(value = "功能url")
    private String url;

    private Integer isDelete;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

}
