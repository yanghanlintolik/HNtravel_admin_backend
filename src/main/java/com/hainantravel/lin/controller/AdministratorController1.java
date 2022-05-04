package com.hainantravel.lin.controller;


import com.alibaba.fastjson.JSONObject;
import com.hainantravel.lin.Result.CodeResult;
import com.hainantravel.lin.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Lin
 * @time: 2020/11/30 17:05
 * @Description: 通过json对象不创建pojo类的方法，来创造前端传值的接受对象
 */

@RestController
@CrossOrigin
public class AdministratorController1 {

    //添加Autowired注释，就不用new，直接写对象即可
    @Autowired
    AdministratorService administratorService;

    @PostMapping(value = "api/administrator_login1")
    @ResponseBody
    public CodeResult login(@RequestBody String requestAdministrator) {
        JSONObject jsonObject=JSONObject.parseObject(requestAdministrator);

        String administratorName = jsonObject.get("username").toString();
        String administratorPwd = jsonObject.get("password").toString();

        String key = administratorService.queryAdministratorByName(administratorName);
        if(!key.equals(administratorPwd)) {
            return new CodeResult(400);
        } else {
            return new CodeResult(200);
        }

    }
}
