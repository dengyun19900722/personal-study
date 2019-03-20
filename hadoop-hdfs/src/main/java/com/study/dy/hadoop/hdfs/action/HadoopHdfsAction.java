package com.study.dy.hadoop.hdfs.action;

import com.study.dy.hadoop.hdfs.service.HadoopHdfsCoreService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * HadoopHdfsAction class
 *
 * @author dengy
 * @date 2019/03/12
 */
@RestController
@RequestMapping("hadoop")
public class HadoopHdfsAction {
    @Autowired
    public HadoopHdfsCoreService hadoopHdfsCoreService;

    @PostMapping("/add")
    public void AddFile() throws IOException{
        hadoopHdfsCoreService.addFile("c:/test.txt", "/user/test");
    }

    @GetMapping("/read")
    public void readFile() throws IOException{
        hadoopHdfsCoreService.readFile("test.txt");
    }
}
