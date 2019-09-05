package com.example.spring.javaconfig;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Bootstrap.MyConfig.class, SpringJavaConfigTest.LocalConfig.class})
class SpringJavaConfigTest {

  @Autowired
  Bootstrap.A a;

  @Test
  void test() {
    String actualValue = a.foo();
    Assertions.assertEquals(StubB.uuid, actualValue);
  }

  static class LocalConfig {
    @Bean
    Bootstrap.B b() {
      return new StubB();
    }
  }

  static class StubB extends Bootstrap.B {
    static String uuid = UUID.randomUUID().toString();

    @Override
    String bar() {
      return uuid;
    }
  }

}
