package com.hainantravel.lin.Result;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/29 13:28
 * @Description: 返回广播列表封装对象
 */
//封装json返回类型时，如果成员方法是私有的private，则必须为其写上get，set方法，否则无法构造对象
public class BroadcastResult<Broadcast> {
    //返回用户List集合
    private List<Broadcast> broadcasts;
    //返回状态码
    private String code;
    //返回提示信息
    private String message;

    //若没有数据返回则提示没查到数据，返回状态码400
    public BroadcastResult(){
        this.code="400";
        this.message="今日未发送过广播";
    }

    //若查询到数据，则返回查询成功和数据
    public BroadcastResult(List<Broadcast> ordersList){
        this.broadcasts = ordersList;
        this.code="200";
        this.message="查询成功";
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

    public List<Broadcast> getBroadcasts(){
        return this.broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts){
        this.broadcasts=broadcasts;
    }


}

