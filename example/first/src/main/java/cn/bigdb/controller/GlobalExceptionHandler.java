package cn.bigdb.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.bigdb.exception.MyExceptionResponse;

//@ControllerAdvice(annotations=RestController.class)
//@ControllerAdvice(basePackages={"com.xxx","com.ooo"})
/**
 * 
 * @ControllerAdvice是controller的一个辅助类，最常用的就是作为全局异常处理的切面类
 * @ControllerAdvice可以指定扫描范围
 * @ControllerAdvice约定了几种可行的返回值，如果是直接返回model类的话，需要使用@ResponseBody进行json转换
 * 返回String，表示跳到某个view
 * 返回modelAndView
 * 返回model + @ResponseBody
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    //    @ExceptionHandler//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public MyExceptionResponse exceptionHandler(RuntimeException e, HttpServletResponse response) {
        MyExceptionResponse resp = new MyExceptionResponse();
        resp.setCode(300);
        resp.setMsg("exception-Handler");
        //        response.setStatus(600);
        return resp;
    }
}