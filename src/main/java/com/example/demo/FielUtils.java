package com.example.demo;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * TODO
 *
 * @author shang
 * @version 1.0
 * @date 2020-12-23 14:25
 */
public class FielUtils {
  public static void downloadFile(File file, HttpServletResponse response){
    OutputStream os = null;
    try {
      // 取得输出流
      os = response.getOutputStream();
      String contentType = Files.probeContentType(Paths.get(file.getAbsolutePath()));
      response.setHeader("Content-Type", contentType);
      response.setHeader("Content-Disposition", "attachment;filename="+ new String(file.getName().getBytes("utf-8"),"ISO8859-1"));
      FileInputStream fileInputStream = new FileInputStream(file);
      WritableByteChannel writableByteChannel = Channels.newChannel(os);
      FileChannel fileChannel = fileInputStream.getChannel();
      fileChannel.transferTo(0,fileChannel.size(),writableByteChannel);
      fileChannel.close();
      os.flush();
      writableByteChannel.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //文件的关闭放在finally中
    finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
