package cn.bigdb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api("测试controllerAdvice和全局异常处理")
@RestController
@RequestMapping("/advice")
public class AdviceController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test1() {
        throw new RuntimeException("advice1 - exception1");
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2() {
        throw new RuntimeException("advice1 - exception2");
    }

    //    @ExceptionHandler(RuntimeException.class)
    //    public MyExceptionResponse exceptionHandler() {
    //        MyExceptionResponse resp = new MyExceptionResponse();
    //        resp.setCode(300);
    //        resp.setMsg("exception-Handler");
    //        return resp;
    //    }

}