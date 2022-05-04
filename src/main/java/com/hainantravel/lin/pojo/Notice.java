package com.hainantravel.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * @author: Lin
 * @time: 2021/1/10 18:57
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
public class Notice {
    @MongoId
    private String id; //id文档对应mysql的记录行
    private String title; //标题
    private String type; //类型
    private String text; //正文内容
    @Field("create_date") //@Field("create_date")注解可以将类中名称和不一样的字段名称进行映射
    private String createDate; //创建时间

}
