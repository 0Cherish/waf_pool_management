package com.maoxian.gateway.service.impl;

import com.maoxian.gateway.exceprion.BusinessException;
import com.maoxian.gateway.mapper.PermMapper;
import com.maoxian.gateway.mapper.UserMapper;
import com.maoxian.gateway.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 加载用户详细信息，权限信息
 *
 * @author Lin
 * @date 2023/9/21 15:30
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //查询用户信息的bean
    @Autowired
    private UserMapper userMapper;

    //查询用户权限的bean
    @Autowired
    private PermMapper permMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }

        //查询用户权限信息
        List<String> list = permMapper.selectByUserId(user.getId());
        if (list.isEmpty()) {
            throw new BusinessException("查询权限失败");
        }

        //把数据封装成UserDetails返回
        return new LoginUser(user, list);
    }
}