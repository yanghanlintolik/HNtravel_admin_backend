package com.hainantravel.lin.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;


public class JwtConfig {

    //密钥
    private static final String  secret = "Dd125859712*";

    //过期时间
    private static long expire = 7200; //以秒计数,3600s一个小时

    //生成token
    public static String createToken(Map<String, String> administrator) throws UnsupportedEncodingException {

        /*
        以日期为设置过期时间，这里为7天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);*/

        Date nowDate = new Date(); //现在时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);//过期时间(以毫秒计数）

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        administrator.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        String token = builder.withExpiresAt(expireDate)//指定令牌过期时间
                .sign(Algorithm.HMAC256(secret));//sign
        return token;
    }

    /**
     * 验证token 合法性
     */
    public static DecodedJWT verify(String token) throws UnsupportedEncodingException {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }

}
