package com.frame.dev.web.controller;

import com.frame.common.base.ResponseData;
import com.frame.dev.web.entity.User;
import com.frame.dev.web.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author derrick.chen
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
        return userService.getAllUsers();
    }
    @GetMapping(value = "/getUserById")
    @ApiOperation(value = "根据id查找单个用户")
    @ResponseBody
    public ResponseData getUserById(long id){
        return userService.getUserById(id);
    }
    @PostMapping(value = "/insertUsers")
    @ApiOperation(value = "新增用户")
    @ResponseBody
    public ResponseData insertUsers(@Valid @RequestBody User user){
        return new ResponseData(0,"SUCCESS",userService.insertUser(user));
    }
    @DeleteMapping(value = "/deleteUsers")
    @ApiOperation(value = "删除用户")
    @ResponseBody
    public ResponseData deleteUsersUsers(Long id){
        return new ResponseData(0,"SUCCESS",userService.removeById(id));
    }
    @GetMapping(value = "/getUserPage")
    @ApiOperation(value = "分页查询用户")
    @ResponseBody
    public ResponseData deleteUsersUsers(int pagenNum, int pageSize){
        return this.userService.getUserPage(pagenNum,pageSize);
    }
    @PutMapping
    @GetMapping(value = "/update")
    @ApiOperation(value = "修改用户")
    public ResponseData updateUser(@Valid User user){
        return this.userService.updateUser(user);
    }


}

