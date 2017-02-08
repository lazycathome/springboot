package cn.bigdb.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Builder
@Getter 
@Setter
@Component
@ConfigurationProperties(prefix = "hystrix")
public class HyStrixProperties {
    private int timeoutInMillions;

}

