package com.example.spring.componentscan;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Bootstrap.MyConfig.class)
class SpringComponentScanTest {

  @Autowired
  Bootstrap.A a;

  @Test
  void test() {
    String actualValue = a.foo();
    Assertions.assertEquals(StubB.uuid, actualValue);
  }

  @Component
  @Primary
  static class StubB extends Bootstrap.B {
    static String uuid = UUID.randomUUID().toString();

    @Override
    String bar() {
      return uuid;
    }
  }

}
