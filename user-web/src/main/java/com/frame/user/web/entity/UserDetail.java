package com.frame.user.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author derrick
 * @since 2019-03-01
 */
@TableName("t_user_detail")
@ApiModel(value="UserDetail对象", description="")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String realName;

    private Integer age;

    private String address;

    private Boolean sex;

    private String remark;

    private Boolean isDelete;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
        "id=" + id +
        ", userId=" + userId +
        ", realName=" + realName +
        ", age=" + age +
        ", address=" + address +
        ", sex=" + sex +
        ", remark=" + remark +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", email=" + email +
        "}";
    }
}
