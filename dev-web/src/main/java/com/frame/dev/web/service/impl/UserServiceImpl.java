package com.frame.dev.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.frame.dev.web.constant.RedisLock;
import com.frame.dev.web.entity.User;
import com.frame.dev.web.mapper.UserMapper;
import com.frame.dev.web.service.IUserService;
import com.frame.common.base.ResponseData;
import com.frame.common.redis.RedisUtils;
import com.frame.common.utils.LongIdGenerator;
import com.frame.dev.web.constant.RedisKey;
/*import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private RedisUtils redisUtils;
//    @Autowired
//    private RedissonClient redissonClient;

    @Override
    public ResponseData<List<User>> getAllUsers() {
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
        //根据用户名加锁，防止多次点击重复插入
        //RLock lock = redissonClient.getLock(String.format(RedisLock.INSERT_USER_KEY_NAME,user.getName()));
        try {
            //boolean isLock = lock.tryLock(3,10, TimeUnit.SECONDS);
            //if(isLock) {
                //判断用户是否已存在
                User oldUser = this.getOne(new QueryWrapper<User>().eq("name", user.getName()));
                if (null != oldUser) {
                    return new ResponseData<>(10001, "该用户已存在，请勿重复插入！");
                }
                Long id = LongIdGenerator.getLongId();
                user.setId(id);
                user.setCreateTime(new Date());
                this.save(user);
         //   }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
       //     lock.unlock();
        }
        return new ResponseData<>(0,"success");
    }

    @Override
    @Transactional
    public ResponseData updateUser(User user) {
        if(null == user.getId()){
            return ResponseData.error("用户id为空，处理失败！");
        }
        String key = String.format(RedisKey.USER_KEY_ID,String.valueOf(user.getId()));
        user.setUpdateTime(new Date());
        this.updateById(user);
        redisUtils.remove(key);
        return ResponseData.success();
    }
}
