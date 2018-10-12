package com.dev.web.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dev.web.entity.User;
import com.dev.web.service.IUserService;
import com.frame.common.object.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author derrick
 * @since 2018-10-12
 */
@Controller
@Api(value = "用户相关控制器")
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping(value = "/getAllUsers")
    @ApiOperation(value = "查找所有用户")
    @ResponseBody
    public ResponseData getAllUsers(){
        return new ResponseData(0,"SUCCESS",userService.selectList(new EntityWrapper<>()));
    }
    @PutMapping(value = "/insertUsers")
    @ApiOperation(value = "新增用户")
    @ResponseBody
    public ResponseData insertUsers(User user){
        return new ResponseData(0,"SUCCESS",userService.insert(user));
    }
    @DeleteMapping(value = "/deleteUsers")
    @ApiOperation(value = "删除用户")
    @ResponseBody
    public ResponseData deleteUsersUsers(Long id){
        return new ResponseData(0,"SUCCESS",userService.deleteById(id));
    }

}

