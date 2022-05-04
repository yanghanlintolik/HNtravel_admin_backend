package com.hainantravel.lin.Result;

import java.util.List;

/**
 * @author: Lin
 * @time: 2021/1/11 14:46
 * @Description: TODO
 */
public class NoticeResult<Notice> {
    //返回用户List集合
    private List<Notice> notices;
    //返回状态码
    private String code;
    //返回提示信息
    private String message;
    //返回总数
    private int total;


    //若没有数据返回则提示没查到数据，返回状态码400
    public NoticeResult(){
        this.code="400";
        this.message="未查到数据";
    }

    //若查询到数据，则返回查询成功和数据
    public NoticeResult(List<Notice> ordersList){
        this.notices = ordersList;
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

    public List<Notice> getNotices(){
        return this.notices;
    }

    public void setNotices(List<Notice> notices){
        this.notices=notices;
    }

    public int getTotal(){
        return this.total;
    }

    public void setTotal(int total){
        this.total=total;
    }
}
