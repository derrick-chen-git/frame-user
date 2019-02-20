package com.frame.dev.web.controller;

import com.frame.common.base.ResponseData;
import com.frame.dev.web.entity.User;
import com.frame.dev.web.service.IUserService;
import com.frame.starter.rabbitmq.sender.RabbitMqSender;
import com.xxl.conf.core.annotation.XxlConf;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
public class UserController {
    @XxlConf("framedev.app.name")
    private String appName;
    @Autowired
    private RabbitMqSender rabbitMqSender;
    @Resource
    private IUserService userService;

    @GetMapping(value = "/getAppName")
    @ApiOperation(value = "查找appName配置")
    @ResponseBody
    public ResponseData getAppName(){
        log.info("获取getAppName++++++++++++++"+appName);
        ResponseData<String> res = ResponseData.success();
        res.setData(appName);
        return res;
    }
    @GetMapping(value = "/getAllUsers")
    @ApiOperation(value = "查找所有用户")
    @ResponseBody
    public ResponseData getAllUsers(){
        log.info("获取所有用户++++++++++++++");
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

    @PostMapping(value = "/sendMq")
    @ApiOperation(value = "发送队列消息")
    @ResponseBody
    public ResponseData getCache(String exchange,String key,String msg){
        log.info("发送队列消息,exchange:{},key:{},msg:{}",exchange,key,msg);
        rabbitMqSender.sendTransMessage(exchange,key,msg,true);
        return ResponseData.success();
    }

}

