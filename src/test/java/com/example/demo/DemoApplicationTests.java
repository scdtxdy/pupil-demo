package com.example.demo;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @since
 */
@SpringBootTest
class DemoApplicationTests {

  private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);
  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Test
  public void testForValue1() {
    String key = "zszxz";
    String value = "?????";
    redisTemplate.opsForValue().set(key, value);
  }

  @Test
  public void testForValue2() {
    String key = "zszxz";
    Object value = redisTemplate.opsForValue().get(key);
    System.out.println(value);
  }

  @Test
  public void testForValue3() {
    String key = "today";
    String value = "??";
    long time = 60;
    redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
  }

  @Test
  void contextLoads() {
  }

}
