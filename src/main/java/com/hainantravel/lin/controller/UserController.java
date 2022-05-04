package com.hainantravel.lin.controller;

import com.hainantravel.lin.Result.CodeResult;
import com.hainantravel.lin.Result.UserResult;
import com.hainantravel.lin.pojo.User;
import com.hainantravel.lin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/1 16:59
 * @Description: 用户列表接口
 */

//RestController返回jason格式封装数据
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "api/users")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public UserResult queryUserList(@RequestParam(name="page",required = true,defaultValue = "1")int page, @RequestParam(name="size",required = true,defaultValue = "10")int size){

        List<User> ordersList = userService.queryUserList(page,size);

        return new UserResult(ordersList);
    }

    @GetMapping(value = "api/totalUsers")
    @ResponseBody
    public int queryTotalUsers(){

        int totalUsers = userService.queryTotalUsers();

        return totalUsers;
    }

    @PostMapping(value = "api/deleteUsers")
    @ResponseBody
    public CodeResult deleteUsers(@RequestBody User user){

        boolean deleteResult= userService.deleteUsers(user);
        System.out.println(user.getId());
        System.out.println(user.getUser_name());
        System.out.println("deleteResult = " + deleteResult);

        if(deleteResult == true){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }
    }

    @PostMapping(value = "api/addUsers")
    @ResponseBody
    public CodeResult addUsers(@RequestBody User user){

        boolean addResult= userService.addUsers(user);
        System.out.println(user.getId());
        System.out.println(user.getUser_name());
        System.out.println("addResult = " + addResult);

        if(addResult == true){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }
    }

    @PostMapping(value = "api/modifyUsers")
    @ResponseBody
    public CodeResult updateUsers(@RequestBody User user){

        System.out.println("user = " + user);
        boolean updateResult= userService.updateUsers(user);


        if(updateResult == true){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }
    }

    @GetMapping(value = "api/queryUsers")
    @ResponseBody
    public UserResult queryUserList(@RequestParam(name="queryType",required = true)String queryType, @RequestParam(name="queryText",required = true)String queryText){
        System.out.println("queryUsersType = " + queryType);
        System.out.println("queryUsersText = " + queryText);
        List<User> queryUserList;
        if(queryType.equals("name")){
            String user_name = queryText;
            queryUserList= userService.queryUserByName(user_name);
        }else{
            int id = Integer.parseInt(queryText);
            queryUserList = userService.queryUserById(id);
        }

        return new UserResult(queryUserList);

    }


}
