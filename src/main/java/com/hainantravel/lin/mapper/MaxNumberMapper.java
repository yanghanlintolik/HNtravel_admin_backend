package com.hainantravel.lin.mapper;

import com.hainantravel.lin.pojo.MaxNumber;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MaxNumberMapper {
    List<Map> getAllNumber();

    boolean modifyNumber(MaxNumber maxNumber);
}
