package com.frame.dev.web.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
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
@TableName("t_user")
@ApiModel(value="User对象", description="")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long id;

    private String name;

    private String password;

    private Date createTime;

    private Date updateTime;

    private int isDelete;
}
