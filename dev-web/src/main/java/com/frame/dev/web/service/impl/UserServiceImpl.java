package com.frame.dev.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frame.common.base.ResponseData;
import com.frame.common.utils.LongIdGenerator;
import com.frame.dev.web.constant.RedisKey;
import com.frame.dev.web.constant.RedisLock;
import com.frame.dev.web.entity.User;
import com.frame.dev.web.mapper.UserMapper;
import com.frame.dev.web.service.IUserService;
import com.frame.starter.redis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author derrick
 * @since 2018-10-12
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public ResponseData<List<User>> getAllUsers() {
        log.info("获取所有用户++++++++++++++");
        return new ResponseData(0,"success",this.list(new QueryWrapper<>()));
    }

    @Override
    public ResponseData<User> getUserById(Long id) {
        String key = String.format(RedisKey.USER_KEY_ID,String.valueOf(id));
        if(redisUtils.exists(key)){
            return new ResponseData<User>(0,"success",(User)redisUtils.get(key));
        }else{
            User user = this.getById(id);
            redisUtils.set(key,user,300L);
            return new ResponseData<User>(0,"success",user);
        }
    }

    @Override
    public ResponseData<IPage<User>> getUserPage(int pageNum, int pageSize) {
        Page<User> page = new Page<User>(pageNum,pageSize);
       IPage<User> ipage = this.page(page,new QueryWrapper<>());
       return new ResponseData<IPage<User>>(0,"success",ipage);
    }

    @Override
    @Transactional
    public Object insertUser(User user) {
        String lockKey = String.format(RedisLock.INSERT_USER_KEY_NAME,user.getName());
        try {
            /* 尝试加锁，最多等待3秒,加锁10秒后自动解锁*/
            boolean isLock = redisUtils.acquireLock(lockKey,3,10, TimeUnit.SECONDS);
            if(isLock) {
                //判断用户是否已存在
                User oldUser = this.getOne(new QueryWrapper<User>().eq("name", user.getName()));
                if (null != oldUser) {
                    return new ResponseData<>(10001, "该用户已存在，请勿重复插入！");
                }
                Long id = LongIdGenerator.getLongId();
                user.setId(id);
                this.save(user);
                return new ResponseData<>(0,"success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            redisUtils.releaseLock(lockKey);
        }
        return null;
    }

    @Override
    @Transactional
    public ResponseData updateUser(User user) {
        if(null == user.getId()){
            return ResponseData.error("用户id为空，处理失败！");
        }
        String key = String.format(RedisKey.USER_KEY_ID,String.valueOf(user.getId()));
        this.updateById(user);
        redisUtils.remove(key);
        return ResponseData.success();
    }
}
