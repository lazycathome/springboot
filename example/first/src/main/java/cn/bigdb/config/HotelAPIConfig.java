package cn.bigdb.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import retrofit.RestAdapter;

@Configuration
public class HotelAPIConfig {
    @Autowired
    private RestAdapter adapter;
    
    @Bean
    public HotelAPI getHotelAPI(){
        return adapter.create(HotelAPI.class);
    }
}
