package com.dev.web.feignservice;

import com.dev.api.api.IUserFeignService;
import com.dev.api.vo.UserInfoDTO;
import com.dev.web.entity.User;
import com.dev.web.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@FeignClient("dev-web")
public class UserServiceFeignImpl implements IUserFeignService {
    @Resource
    private IUserService userService;
    @Override
    public List<UserInfoDTO> getAllUsers() {
        List<User> users = userService.getAllUsers().getData();
        List<UserInfoDTO> dtos = new ArrayList<>();
        if(null != users && users.size() > 0){
            for(User user : users){
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                BeanUtils.copyProperties(userInfoDTO,user);
                dtos.add(userInfoDTO);
            }
        }
        return dtos;
    }
}
