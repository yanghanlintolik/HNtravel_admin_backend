package com.hainantravel.lin.controller;

import com.hainantravel.lin.Result.BroadcastResult;
import com.hainantravel.lin.Result.CodeResult;
import com.hainantravel.lin.pojo.Broadcast;
import com.hainantravel.lin.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/29 13:10
 * @Description: 景区广播控制器
 */
@RestController
@CrossOrigin
public class BroadcastController {
    @Autowired
    BroadcastService broadcastService;

    //保存一条广播内容
    @PostMapping(value = "api/saveBroadcast")
    @ResponseBody
    public CodeResult saveBroadcast(@RequestBody Broadcast broadcast){
        boolean saveResult= broadcastService.saveBroadcast(broadcast);
        if(saveResult == true){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }
    }

    @GetMapping(value = "api/queryBroadcast")
    @ResponseBody
    //param定义请求的格式为名称限定，不能为空，默认值
    public BroadcastResult queryBroadcast(){

        List<Broadcast> ordersList = broadcastService.queryBroadcast();

        return new BroadcastResult(ordersList);
    }

}
