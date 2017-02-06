package cn.bigdb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.bigdb.archaius.ConsulConfigurationSource;

import com.netflix.config.AbstractPollingScheduler;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;

@Api("archaius相关API")
@RestController
@RequestMapping("/consul")
public class ArchaiusController {

	@ApiOperation("get KV from consul by archaius")
    @RequestMapping(value="/kv2/",method=RequestMethod.GET)
    public void getKVByArchaius(@RequestParam("key") String key) throws IOException {
        
        PolledConfigurationSource source = new ConsulConfigurationSource(key);//定义读取配置的源头
        AbstractPollingScheduler scheduler = new FixedDelayPollingScheduler();//设置读取配置文件的
        DynamicConfiguration configuration = new DynamicConfiguration(source, scheduler);
        
        ConfigurationManager.install(configuration);
        
        DynamicStringProperty dsp = DynamicPropertyFactory.getInstance().getStringProperty("mysql.driverClassName", "zhaojigangDriver");
        System.out.println("当前时间：" + LocalDateTime.now() + "-->值：" + dsp.get());
        try {
            Thread.sleep(60000);//睡60s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前时间：" + LocalDateTime.now() + "-->值：" + dsp.get());
    }
	
}
