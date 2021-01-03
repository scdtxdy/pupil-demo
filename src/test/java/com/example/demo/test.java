package com.example.demo;

import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import io.minio.MinioClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

/**
 * TODO
 *
 * @author shang
 * @version 1.0
 * @date 2020-12-25 15:33
 */
@SpringBootTest
class MinioTest {
  private static final Logger log = LoggerFactory.getLogger(MinioTest.class);

  @Test
  public void testUpload() throws FileNotFoundException {
    try {
      // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
      MinioClient minioClient = new MinioClient("http://192.168.2.243", 9000, "admin", "admin123456");

      // 检查存储桶是否已经存在
      boolean isExist = minioClient.bucketExists("pupilman");
      if(isExist) {
        log.info("Bucket already exists.");
      } else {
        // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
        minioClient.makeBucket("pupilman");
      }

      // 使用putObject上传一个文件到存储桶中。
      minioClient.putObject("pupilman","test.jpg", "C:\\Users\\shang\\Downloads\\2e1g9y.jpg");
      log.info("/home/user/Photos/asiaphotos.zip is successfully uploaded as asiaphotos.zip to `asiatrip` bucket.");
    } catch(Exception e) {
      log.info("Error occurred: " + e);
  }
  }
}

