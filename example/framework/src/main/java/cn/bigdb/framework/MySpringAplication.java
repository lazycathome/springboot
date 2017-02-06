package cn.bigdb.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringAplication {

    public void run(String[] args) {
        SpringApplication sa = new SpringApplication(MySpringAplication.class);
        sa.run(args);
    }

}