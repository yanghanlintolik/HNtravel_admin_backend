package com.hainantravel.lin.Result;

/**
 * @author: Lin
 * @time: 2020/11/21 14:17
 * @Decription: 管理员登录响应码
 */

public class CodeResult {
    //响应码
    private int code;

    public CodeResult(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}