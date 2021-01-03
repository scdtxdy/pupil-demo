package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @author shang
 * @version 1.0
 * @date 2020-12-22 21:48
 */
@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {

  /**
   * 上传文件保存的本地目录
   *
   * @param null
   * @author shang
   * @date 2020-12-22 21:50
   * @return
   */
  @Value("${accessFile.location}")
  private String location;

  /**
   * 匹配url 中的资源映射
   *
   * @param null
   * @author shang
   * @date 2020-12-22 21:49
   * @return
   */
  @Value("${accessFile.resourceHandler}")
  private String resourceHandler;

  /**
   *
   *
   * @param registry
   * @author shang
   * @date 2020-12-22 21:50
   * @return addResourceHandlers
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //匹配到resourceHandler,将URL映射至location,也就是本地文件夹
    registry.addResourceHandler(resourceHandler).addResourceLocations("file:///" + location);
  }

}
