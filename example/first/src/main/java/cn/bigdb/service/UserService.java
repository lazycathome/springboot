package cn.bigdb.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bigdb.config.HotelAPI;
import cn.bigdb.entity.Hotel;
import cn.bigdb.entity.User;

@Service
public class UserService {
    
    @Autowired
    private User user;
    
    @Autowired
    private HotelAPI hotelApi;
    
    public Hotel getHotelFromMyboot2WithQueryParameter(String hotelname){
        return hotelApi.getHotelWithQueryParameter(hotelname);
    }
    
    public List<Hotel> getHotelFromMyboot2List(){
        return hotelApi.getHotelList();//测试post请求
    }
    
    public List<Hotel> getHotelFromMyboot2ListWithBody(Hotel hotel){
        return hotelApi.getHotelListWithBody(hotel);//测试post请求
    }
    
    public User getUser(){
        return user;
    }

}