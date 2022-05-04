package com.hainantravel.lin.mapper;

import com.hainantravel.lin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //返回所有用户数
    int queryTotalUsers();

    //返回查询的用户
    List<User> queryUserList(@Param("page")int page, @Param("size")int size);

    //通过id查找用户
    List<User> queryUserById(@Param("id") int id);

    //通过用户名查找
    List<User> queryUserByName(@Param("user_name") String user_name);

    //插入一个用户
    boolean addUser(User user);

    //更新一个用户
    boolean updateUser(User user);

    //删除一个用户
    boolean deleteUser(int id);

}
