package cn.bigdb.servlet;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    
    @Bean
    public TestServlet testServlet(){
        return new TestServlet();
    }
    
    @Bean
    public ServletRegistrationBean testServletRegistrationBean(TestServlet testServlet){
        ServletRegistrationBean registration = new ServletRegistrationBean(testServlet);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test");
        return registration;
    }
    /********************************************/
    @Bean
    public TestServlet2 testServlet2(){
        return new TestServlet2();
    }
    
    @Bean
    public ServletRegistrationBean test2ServletRegistrationBean(TestServlet2 testServlet2){
        ServletRegistrationBean registration = new ServletRegistrationBean(testServlet2);
        registration.setEnabled(true);
        registration.addUrlMappings("/servlet/test2");
        return registration;
    }
    
}