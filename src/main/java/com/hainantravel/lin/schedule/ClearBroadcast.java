package com.hainantravel.lin.schedule;

import org.springframework.stereotype.Component;

/**
 * @author: Lin
 * @time: 2020/12/31 11:33
 * @Description: 定时清空广播内容
 */

//标注Spring管理的Bean，使用@Component注解在一个类上，表示将此类标记为Spring容器中的一个Bean。
@Component
public class ClearBroadcast
{
//    //注入service对象 方便调用
//    @Resource
//    private clearService clearservice;
//    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
//    public void execute(){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
//        System.out.println("欢迎访问 pan_junbiao的博客 " + df.format(new Date()));
//    }
}