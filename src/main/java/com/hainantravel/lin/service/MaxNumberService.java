package com.hainantravel.lin.service;

import com.hainantravel.lin.mapper.MaxNumberMapper;
import com.hainantravel.lin.pojo.MaxNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: Lin
 * @time: 2021/3/15 19:50
 * @Description: TODO
 */
@Service
public class MaxNumberService {

    @Autowired
    private MaxNumberMapper maxNumberMapper;

    public List<Map> getAllNumber(){
        List<Map> numberList = maxNumberMapper.getAllNumber();
        return numberList;
    }

    public boolean modifyNumber(MaxNumber maxNumber){
        boolean modifyResult = maxNumberMapper.modifyNumber(maxNumber);
        return modifyResult;
    }
}
