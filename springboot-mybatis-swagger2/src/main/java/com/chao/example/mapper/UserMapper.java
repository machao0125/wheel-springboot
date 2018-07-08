package com.chao.example.mapper;

import com.chao.example.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * Created by machao on 2018/7/7.
 */
@Mapper
public interface UserMapper {
    User getOne(Long id);

    void insert(User user);

    void update(User user);

    List<User> listAll();

    void deleteByIds(List<Long> ids);

    void stop(Long id);

    void enable(Long id);

    User login(@Param("account") String account, @Param("password") String password);
}
