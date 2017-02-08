package cn.bigdb.redis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bigdb.redis.entity.User;

@Service
public class UserService {
    
    @Autowired
    private User user;
   
    public User getUser(){
        return user;
    }

}