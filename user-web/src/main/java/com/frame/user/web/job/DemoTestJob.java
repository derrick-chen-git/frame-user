package com.frame.user.web.job;

import com.alibaba.fastjson.JSON;
import com.frame.user.web.entity.User;
import com.frame.user.web.service.IUserService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by derrick on 2019/1/5.
 */
@JobHandler(value = "demoTestJob")
@Component
@Slf4j
public class DemoTestJob extends IJobHandler{
    @Autowired
    private IUserService userService;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        //log.info("DemoTestJob is start ++++++");
        XxlJobLogger.log("DemoTestJob is start ++++++");
        //log.info("DemoTestJob is start ++++++");
        List<User> users = this.userService.getAllUsers().getData();
        XxlJobLogger.log("DemoTestJob user:{}", JSON.toJSONString(users));
        log.info("DemoTestJob user:{}", JSON.toJSONString(users));
        //log.info("DemoTestJob is end ++++++");
        XxlJobLogger.log("DemoTestJob is end ++++++");
        return SUCCESS;
    }
}
