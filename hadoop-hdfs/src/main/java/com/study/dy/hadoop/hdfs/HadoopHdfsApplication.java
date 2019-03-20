package com.study.dy.hadoop.hdfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * HadoopHdfs启动类
 *
 * @author dengy
 * @date 2019/03/12
 */
@SpringBootApplication
@EnableSwagger2
public class HadoopHdfsApplication {
	public static void main(String[] args) {
		SpringApplication.run(HadoopHdfsApplication.class, args);
	}
}
