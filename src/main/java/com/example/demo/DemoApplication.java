package com.example.demo;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author shang
 */
@SpringBootApplication
@RestController
@RequestMapping("/demo")
public class DemoApplication {

  @Value("${accessFile.location}")
  private String location;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @GetMapping
  public String hello() {
    return "hello";
  }

  @GetMapping("/test")
  public String test() {return "Test";}
}

