package com.hainantravel.lin.controller;

import com.alibaba.fastjson.JSONObject;
import com.hainantravel.lin.Result.LoginResult;
import com.hainantravel.lin.config.JwtConfig;
import com.hainantravel.lin.pojo.Administrator;
import com.hainantravel.lin.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Lin
 * @time: 2020/12/1 10:45
 * @Description: 通过创建pojo类的方法，来创造前端传值的接受对象
 */
@RestController
@CrossOrigin
public class AdministratorController2 {

    @Autowired
    //创造service层对象以提供方法调用
    AdministratorService administratorService;


    @PostMapping(value = "api/administrator_login2")
    @ResponseBody
    public LoginResult login(@RequestBody Administrator requestAdministrator) throws Exception{
        //前端传值后，以传输的值创建一个pojo对象，通过pojo对象调用方法，获取名称和密码
        String administratorName = requestAdministrator.getUsername();
        String administratorPwd = requestAdministrator.getPassword();
        //通过查询数据库用户名匹配的密码来进行校验
        String key = administratorService.queryAdministratorByName(administratorName);
        //创建一个String,String的map集合，以供后续的tokens生成
        Map<String,String> administrator =  new HashMap<>();
        //map集合中放入信息
        administrator.put("id",String.valueOf(requestAdministrator.getId()));
        administrator.put("name",requestAdministrator.getUsername());
        //创建json对象以存储token内容
        JSONObject jwt = new JSONObject();
        String token = JwtConfig.createToken(administrator) ;
        jwt.put("token",token) ;
        System.out.println("jwt = " + jwt);

        if(!key.equals(administratorPwd)) {
            //判断不匹配时返回400
           return new LoginResult(400);
        } else {
            //判断匹配时返回200和token信息
            return new LoginResult(200,token);
        }
    }
}