package com.hainantravel.lin.service;

import com.hainantravel.lin.mapper.BroadcastMapper;
import com.hainantravel.lin.pojo.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Lin
 * @time: 2020/12/29 13:15
 * @Description: TODO
 */
@Service
public class BroadcastService {
    //维护一个私有的Mapper变量，以提供方法调用
    @Autowired
    private BroadcastMapper broadcastMapper;

    //查询所有广播内容
    public List<Broadcast> queryBroadcast(){
        //sql limit查询语句中，第一个参数不是页数，而是开始索引，为实现页数，应按（page-1）*size进行运算
        List<Broadcast> broadcastList = broadcastMapper.queryBroadcast();
        return broadcastList;

    }
    //保存一条广播内容
    public boolean saveBroadcast(Broadcast broadcast){
        boolean result = broadcastMapper.saveBroadcast(broadcast);
        return result;
    }


}
