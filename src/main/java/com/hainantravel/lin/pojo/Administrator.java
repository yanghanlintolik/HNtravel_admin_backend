package com.hainantravel.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lin
 * @time: 2020/11/30 11:39
 * @Description:管理员pojo类,用来存放管理员的数据，不涉及对数据的操作
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
       private int id;
       private String username;
       private String password;
}
