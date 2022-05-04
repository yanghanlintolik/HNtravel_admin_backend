package com.hainantravel.lin.controller;

/**
 * @author: Lin
 * @time: 2021/1/5 18:46
 * @Description: 测试专用接口
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        //处理自己业务逻辑
        map.put("state",true);
        map.put("msg","请求成功!");
        return map;
    }

}
