package com.frame.user.api.api;


import com.frame.user.api.vo.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface IUserFeignService {
    /**
     *获取所有用户
     */
    @RequestMapping(value = "/userFeign/getAllUsers", method = RequestMethod.GET)
    List<UserInfoDTO> getAllUsers();

}
