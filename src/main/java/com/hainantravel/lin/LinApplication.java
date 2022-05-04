package com.hainantravel.lin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//需要加上该注解才能在项目启动时扫描类，为其填上跨域头
@ServletComponentScan
@EnableScheduling //开启定时任务
public class LinApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinApplication.class, args);
	}

}
