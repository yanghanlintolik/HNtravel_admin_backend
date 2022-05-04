package com.hainantravel.lin.service;

import com.hainantravel.lin.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Lin
 * @time: 2020/12/1 10:10
 * @Description: Service层创建对象，以供Controller层调用
 */
@Service
public class AdministratorService {
    //维护一个私有的Mapper变量，以提供方法调用
    @Autowired
    private AdministratorMapper administratorMapper;
    public String queryAdministratorByName(String administratorName){
        //SQL语句是在mapper层映射xml文件而得，因此调用mapper层方法
        String key = administratorMapper.queryAdministratorByName(administratorName);
        return key;
    }

}
