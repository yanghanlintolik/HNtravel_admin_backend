package com.hainantravel.lin.service;

import com.hainantravel.lin.mapper.UserMapper;
import com.hainantravel.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/1 20:19
 * @Description: Service层创建对象，以供Controller层调用
 */

@Service
public class UserService {
    //维护一个私有的Mapper变量，以提供方法调用
    @Autowired
    private UserMapper userMapper;

    //根据页码查找数据总数
    public List<User> queryUserList(int page, int size){

        //sql limit查询语句中，第一个参数不是页数，而是开始索引，为实现页数，应按（page-1）*size进行运算
        List<User> ordersList = userMapper.queryUserList((page-1)*size,size);
        return ordersList;

    }

    //查询数据库中存有数据总数
    public int queryTotalUsers(){
        int totalUsers = userMapper.queryTotalUsers();
        return totalUsers;
    }

    //删除用户
    public boolean deleteUsers(User user){
        boolean result = userMapper.deleteUser(user.getId());
        System.out.println(user.getId());
        return result;
    }

    //添加用户
    //根据id删除数据
    public boolean addUsers(User user){
        boolean result = userMapper.addUser(user);
        System.out.println(user);
        return result;
    }

    //更新用户数据
    public boolean updateUsers(User user){
        boolean result = userMapper.updateUser(user);
        return result;
    }

    //根据名称查找用户
    public List<User> queryUserByName(String user_name){
        List<User> queryUserList = userMapper.queryUserByName(user_name);
        return queryUserList;
    }

    //根据id查找用户
    public List<User> queryUserById(int id){
        List<User> queryUserList = userMapper.queryUserById(id);
        return queryUserList;
    }

}
