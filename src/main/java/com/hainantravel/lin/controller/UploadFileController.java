package com.hainantravel.lin.controller;

import com.hainantravel.lin.pojo.WangEditor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Lin
 * @time: 2020/12/28 16:25
 * @Description: TODO
 */

@RestController
@Component
public class UploadFileController {
    //从配置文件中读取存储地址
    @Value("${upload.filePath}")
    private String filePath;

    //返回前端的前置url地址
    @Value("${upload.url}")
    private String url;


    @RequestMapping(value = "/api/upload_img", method = RequestMethod.POST)
    public WangEditor uploadSource(@RequestParam("myfile") MultipartFile file, HttpServletRequest request) {
        String pathString = null; //存放总地址
        //设置图片上传路径
        //String url = request.getSession().getServletContext().getRealPath("/upload");
        String path = null; //图片名称

        if (file != null) {
            path = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + file.getOriginalFilename();
            pathString = filePath + path;
            System.out.println("pathString = " + pathString);
        }

        WangEditor we = null;
        try {
            File files = new File(pathString);
            //判断文件地址是否为空，为空时新建
            if (!files.getParentFile().exists()) {
                files.getParentFile().mkdirs();
            }
            //将内存中的数据写入磁盘
            file.transferTo(files);
            // 返回图片访问路径
            //String imgurl = request.getScheme() + "://" + request.getServerName()
            //+ ":" + request.getServerPort() + "/upload/" + path;
            String imgUrl =  url+path;
            System.out.println("返回给前端的imgUrl地址= " + imgUrl);
            String[] str ={imgUrl};
            we = new WangEditor(str);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("上传失败，e = " + e);
        }
        return we;

    }
}
