package com.hainantravel.lin.controller;

import com.hainantravel.lin.Result.CodeResult;
import com.hainantravel.lin.pojo.MaxNumber;
import com.hainantravel.lin.service.MaxNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Lin
 * @time: 2021/3/15 17:01
 * @Description: TODO
 */
@RestController
@CrossOrigin
public class MaxNumberController {
    @Autowired
    MaxNumberService maxNumberService;

    @GetMapping(value = "api/maxValue")
    @ResponseBody
    public List<Map> getMaxNumber(){
        List<Map> List = maxNumberService.getAllNumber();
        return List;
    }

    @PostMapping(value="api/modifyMax")
    @ResponseBody
    public CodeResult modifyMax(@RequestBody MaxNumber maxNumber){
        System.out.println("maxNumber = " + maxNumber);

        boolean modifyResult = maxNumberService.modifyNumber(maxNumber);

        if(modifyResult == true){
            return new CodeResult(200);
        } else {
            return new CodeResult(400);
        }

    }
}
