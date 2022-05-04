package com.hainantravel.lin.pojo;

import lombok.Data;

import java.util.Arrays;

/**
 * @author: Lin
 * @time: 2020/12/28 16:18
 * @Description: 前端Editor传图片返回的pojo类
 */
@Data
public class WangEditor {
    private Integer errno; //错误代码，0 表示没有错误。
    private String[] data; //已上传的图片路径
    public WangEditor() {
        super();
    }
    public WangEditor(String[] data) {
        super();
        this.errno = 0;
        this.data = data;
    }
    public Integer getErrno() {
        return errno;
    }
    public void setErrno(Integer errno) {
        this.errno = errno;
    }
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "WangEditor [errno=" + errno + ", data=" + Arrays.toString(data)
                + "]";
    }
}