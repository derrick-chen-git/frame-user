package com.frame.user.web.feign;

import com.frame.common.base.ResponseData;
import com.frame.dev.api.api.IUserFeignService;
import com.frame.dev.api.vo.UserInfoDTO;
import com.frame.user.web.entity.User;
import com.frame.user.web.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserServiceFeignImpl implements IUserFeignService {
    @Resource
    private IUserService userService;
    @Override
    public List<UserInfoDTO> getAllUsers() {
        ResponseData<List<User>> res = userService.getAllUsers();
        List<User> users =res.getData();
        List<UserInfoDTO> dtos = new ArrayList<>();
        if(null != users && users.size() > 0){
            for(User user : users){
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                BeanUtils.copyProperties(user,userInfoDTO);
                dtos.add(userInfoDTO);
            }
        }
        return dtos;
    }
}
