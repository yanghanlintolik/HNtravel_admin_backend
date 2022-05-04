package com.hainantravel.lin.controller;

import com.hainantravel.lin.Result.CodeResult;
import com.hainantravel.lin.Result.NoticeResult;
import com.hainantravel.lin.pojo.Notice;
import com.hainantravel.lin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Lin
 * @time: 2021/1/10 21:07
 * @Description: 通知Notice控制类
 */
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    //获取通知列表
    @GetMapping(value = "api/getAllNotice")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public NoticeResult getAllNotice(@RequestParam(name="page",required = true,defaultValue = "1")Integer page, @RequestParam(name="pageSize",required = true,defaultValue = "10")Integer pageSize){

        return new NoticeResult(noticeService.findAllByPage(page, pageSize));
    }

    //查询通知
    @GetMapping(value = "api/queryNotice")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public NoticeResult queryNotice(@RequestParam(name="queryText",required = true)String queryText){
        System.out.println("queryText = " + queryText);
        return new NoticeResult(noticeService.queryNotice(queryText));
    }

    //保存通知
    @PostMapping(value = "api/addNotice")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public CodeResult addNotice(@RequestBody Notice notice){
        Notice addResult= noticeService.addNotice(notice);
        System.out.println("addResult = " + addResult);
        //instanceof是Java的一个运算符，判断一个对象是否为一个类的实例,这里判断addResult是Notice的实例
        if(addResult instanceof Notice){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }
    }

    //获取通知总数，返回long型数据，
    @GetMapping(value = "api/totalNotice")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public long totalNotice(){
        long total = noticeService.queryTotal();
        return total;
    }
}
