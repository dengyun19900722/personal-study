package com.study.dy.hadoop.hdfs.service.impl;

import com.study.dy.hadoop.hdfs.service.HadoopHdfsCoreService;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * HadoopHdfsCoreServiceImpl class
 *
 * @author dengy
 * @date 2019/03/12
 */
@Service
public class HadoopHdfsCoreServiceImpl implements HadoopHdfsCoreService {
    private Configuration getConf(){
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.43.25:9000");
        return conf;
    }
    @Override
     public void addFile(String source, String dest) throws IOException {
        FileSystem fileSystem = FileSystem.get(getConf());
        // Get the filename out of the file path
        String filename = source.substring(source.lastIndexOf('/') + 1,source.length());
        // Create the destination path including the filename.
        if (dest.charAt(dest.length() - 1) != '/') {
            dest = dest + "/" + filename;
        } else {
            dest = dest + filename;
        }
        // System.out.println("Adding file to " + destination);
        // Check if the file already exists
        Path path = new Path(dest);
        if (fileSystem.exists(path)) {
            System.out.println("File " + dest + " already exists");
            return;
        }

        // Create a new file and write data to it.
        FSDataOutputStream out = fileSystem.create(path);
        InputStream in = new BufferedInputStream(new FileInputStream(new File(
                source)));

        byte[] b = new byte[1024];
        int numBytes = 0;
        while ((numBytes = in.read(b)) > 0) {
            out.write(b, 0, numBytes);
        }

        // Close all the file descriptors
        in.close();
        out.close();
        fileSystem.close();
    }

    @Override
    public void readFile(String file) throws IOException {
        FileSystem fileSystem = FileSystem.get(getConf());

        Path path = new Path(file);
        if (!fileSystem.exists(path)) {
            System.out.println("File " + file + " does not exists");
            return;
        }

        FSDataInputStream in = fileSystem.open(path);

        String filename = file.substring(file.lastIndexOf('/') + 1,
                file.length());

        OutputStream out = new BufferedOutputStream(new FileOutputStream(
                new File(filename)));

        byte[] b = new byte[1024];
        int numBytes = 0;
        while ((numBytes = in.read(b)) > 0) {
            out.write(b, 0, numBytes);
        }

        in.close();
        out.close();
        fileSystem.close();
    }

    @Override
    public void deleteFile(String file) throws IOException {
        FileSystem fileSystem = FileSystem.get(getConf());

        Path path = new Path(file);
        if (!fileSystem.exists(path)) {
            System.out.println("File " + file + " does not exists");
            return;
        }

        fileSystem.delete(new Path(file), true);

        fileSystem.close();
    }

    @Override
    public void mkdir(String dir) throws IOException {
        FileSystem fileSystem = FileSystem.get(getConf());

        Path path = new Path(dir);
        if (fileSystem.exists(path)) {
            System.out.println("Dir " + dir + " already not exists");
            return;
        }

        fileSystem.mkdirs(path);

        fileSystem.close();
    }
}
