package com.chao.example.service.impl;

import com.chao.example.domain.User;
import com.chao.example.mapper.UserMapper;
import com.chao.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by machao on 2018/7/7.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getOne(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        userMapper.deleteByIds(ids);
    }

    @Override
    public void stop(Long id) {
        userMapper.stop(id);
    }

    @Override
    public void enable(Long id) {
        userMapper.enable(id);
    }

    @Override
    public User login(String account, String password) {
        return userMapper.login(account,password);
    }
}
