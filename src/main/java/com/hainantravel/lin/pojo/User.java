package com.hainantravel.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lin
 * @time: 2020/12/1 15:09
 * @Description: 用户pojo类,存放用户数据
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    private String user_name;
    private String user_label;
    private String user_sex;
    private String user_birthday;
    private String user_address;
    private String user_tell;
    private String user_profession;
    //用户画像，存放的是网址
    private String user_image;
}
