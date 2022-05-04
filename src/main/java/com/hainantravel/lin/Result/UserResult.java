package com.hainantravel.lin.Result;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/2 9:41
 * @Description: 返回用户列表封装对象
 */
//封装json返回类型时，如果成员方法是私有的private，则必须为其写上get，set方法，否则无法构造对象
public class UserResult<User> {
    //返回用户List集合
    private List<User> users;
    //返回状态码
    private String code;
    //返回提示信息
    private String message;
    //返回总数
    private int total;


    //若没有数据返回则提示没查到数据，返回状态码400
    public UserResult(){
        this.code="400";
        this.message="未查到数据";
    }

    //若查询到数据，则返回查询成功和数据
    public UserResult(List<User> ordersList){
        this.users = ordersList;
        this.code="200";
        this.message="查询成功";
        this.total= ordersList.size();
    }

    public String getMessage(){
        return message;
    }

    public String getCode(){
        return code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setCode(String code){
        this.code = code;
    }

    public List<User> getUsers(){
        return this.users;
    }

    public void setUsers(List<User> users){
        this.users=users;
    }

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int total){
        this.total=total;
    }
}
