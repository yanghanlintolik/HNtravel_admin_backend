package com.hainantravel.lin.mapper;


import com.hainantravel.lin.pojo.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示这是mybatis的一个mapper类，只有加上才能被application扫描到
@Mapper
@Repository
public interface AdministratorMapper {

    //返回所有的管理员账号
    List<Administrator> queryAdministratorList();

    //通过id查找管理员账号
    Administrator queryAdministratorById();

    //通过账户名和密码查询
    String queryAdministratorByName(@Param("administratorName") String administratorName);

    //插入一个管理员账户
    int addAdministrator(Administrator administrator);

    //更新一个管理员账户
    int updateAdministrator(Administrator administrator);

    //删除一个管理员账户
    int deleteAdministrator(Administrator administrator);


}
