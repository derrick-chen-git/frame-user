package com.dev.web.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
@TableName("t_user_detail")
public class UserDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private Long id;
    private String address;
    private String realName;
    private String idCardNo;
    private Integer userId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
        "id=" + id +
        ", address=" + address +
        ", realName=" + realName +
        ", idCardNo=" + idCardNo +
        ", userId=" + userId +
        "}";
    }
}
