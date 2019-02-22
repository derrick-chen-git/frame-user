package com.frame.user.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author derrick
 * @since 2018-12-28
 */
@TableName("t_user_detail")
@ApiModel(value="UserDetail对象", description="")
@Data
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String name;

    private Integer age;

    private String address;

    private Boolean sex;

    private String remark;

    private Boolean isDelete;

    private Date createTime;

    private Date updateTime;

}
