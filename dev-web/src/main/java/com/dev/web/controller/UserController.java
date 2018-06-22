package com.dev.web.controller;


import com.frame.common.object.ResponseData;
import com.dev.web.entity.User;
import com.dev.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author derrick
 * @since 2018-06-22
 */
@Slf4j
@Controller
@RequestMapping("/user")
@Api(value = "用户相关接口", tags = {"用户相关接口"})
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping(value = "/getAllUsers")
    @ApiOperation(value = "获取所用用户")
    public ResponseData<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return new ResponseData(0,"SUCCESS",users);
    }
    @ResponseBody
    @GetMapping(value = "/getUsersById")
    @ApiOperation(value = "获取所用用户")
    public ResponseData<User> getUsersById(long userId){
        User user = userService.getUserById(userId);
        return new ResponseData(0,"SUCCESS",user);
    }
}

