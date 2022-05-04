package com.hainantravel.lin.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hainantravel.lin.config.JwtConfig;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Lin
 * @time: 2021/1/4 22:08
 * @Description: jwt拦截器,需要实现HandlerInterceptor接口
 */

public class JwtInterceptor implements HandlerInterceptor {

    //在springboot的新版本中不要求强制实现handle了，这里实现preHandle，也就是预先处理
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断如果是option请求则结束情求不进行token判断
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return false;
        }
        //之后前端发送的请求，token信息一般存储在请求头中，所以这里从请求头中获取token信息
        String token = request.getHeader("token");
        System.out.println("前端发送的token为 = " + token);
        //创建集合以存储token验证过程信息
        Map<String, Object> map = new HashMap<>();
        //验证过程
        try {
            JwtConfig.verify(token);//验证令牌
            return true;//放行请求
        }catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg","无效签名!");
            map.put("errorID",1);
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","token过期!");
            map.put("errorID",2);
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","token算法不一致!");
            map.put("errorID",3);
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","token无效或其他非token原因导致错误");
            map.put("errorID",4);
        }
        map.put("state",false);//设置map状态为错误
        //将map转为json  jackson
        String json = new ObjectMapper().writeValueAsString(map);
        //设置响应格式
        response.setContentType("application/json;charset=UTF-8");
        //返回json
        response.getWriter().println(json);
        return false;
    }
}
