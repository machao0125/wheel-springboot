package com.chao.example.service;

import com.chao.example.domain.User;
import org.jboss.logging.Param;

import java.util.List;

/**
 * Created by machao on 2018/7/7.
 */
public interface IUserService {
    User getOne(Long id);

    void insert(User user);

    void update(User user);

    List<User> listAll();

    void deleteByIds(List<Long> ids);

    void stop(Long id);

    void enable(Long id);

    User login(String account, String password);
}
