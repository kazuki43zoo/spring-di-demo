package com.example.di.setter;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetterInjectionTest {

  @Test
  void test() {
    String uuid = UUID.randomUUID().toString();
    Bootstrap.B stubB = new Bootstrap.B() {
      @Override
      String bar() {
        return uuid;
      }
    };
    Bootstrap.A a = new Bootstrap.A();
    a.setB(stubB);
    String actualValue = a.foo();
    Assertions.assertEquals(uuid, actualValue);
  }

}
