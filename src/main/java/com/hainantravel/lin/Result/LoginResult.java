package com.hainantravel.lin.Result;

import lombok.Data;

/**
 * @author: Lin
 * @time: 2021/1/4 17:23
 * @Description: 管理员登录结果
 */
@Data
//lombok全参构造器@AllArgsConstructor
//lombok部分参构造器@RequiredArgsConstructor 无参构造器@NoArgsConstructor
public class LoginResult {
    //响应码
    private int code;
    private String token;

    //自定义部分参构造器
    public LoginResult(int code){
        this.code = code;
    }

    //自定义全参构造器
    public LoginResult(int code,String token){
        this.code = code;
        this.token = token;
    }
}
