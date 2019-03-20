package com.study.dy.hadoop.hdfs.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;

/**
 * HadoopHdfsCoreService interface
 *
 * @author dengy
 * @date 2019/03/12
 */
public interface HadoopHdfsCoreService {
        /**
         * create a existing file from local filesystem to hdfs
         * @param source
         * @param dest
         * @throws IOException
         */
        void addFile(String source, String dest) throws IOException;

        /**
         * read a file from hdfs
         * @param file
         * @throws IOException
         */
        void readFile(String file) throws IOException;

        /**
         * delete a directory in hdfs
         * @param file
         * @throws IOException
         */
        void deleteFile(String file) throws IOException;

        /**
         * create directory in hdfs
         * @param dir
         * @throws IOException
         */
        void mkdir(String dir) throws IOException;

}
