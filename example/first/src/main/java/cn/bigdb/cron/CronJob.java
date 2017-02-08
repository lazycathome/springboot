package cn.bigdb.cron;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * cron测试
 */
//@Configuration
@Component
public class CronJob {

    int i = 0;

    @Scheduled(cron = "${job.everysecond2.cron}")
    public void everySecond() {
        System.out.println("第" + (++i) + "次调用，每秒任务，当前时间：" + nowTime());
    }
    
    private String nowTime() {
        return DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
    }
}