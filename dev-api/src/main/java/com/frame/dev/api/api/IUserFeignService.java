package com.frame.dev.api.api;


import com.frame.dev.api.vo.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface IUserFeignService {
    /**
     *获取所有用户
     */
    @RequestMapping(value = "/user/getAllUsers", method = RequestMethod.GET)
    List<UserInfoDTO> getAllUsers();

}
