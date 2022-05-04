package com.hainantravel.lin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lin
 * @time: 2020/12/29 13:13
 * @Description: 广播对象
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Broadcast {
    private String release_time;
    private String broadcast_content;
    private String broadcast_type;
}
