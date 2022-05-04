package com.hainantravel.lin.mapper;

import com.hainantravel.lin.pojo.Broadcast;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BroadcastMapper {

    //返回所有广播内容
    List<Broadcast> queryBroadcast();

    //保存一条广播
    boolean saveBroadcast(Broadcast broadcast);

}
