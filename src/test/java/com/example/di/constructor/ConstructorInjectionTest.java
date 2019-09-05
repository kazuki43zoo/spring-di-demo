package com.example.di.constructor;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConstructorInjectionTest {

  @Test
  void test() {
    String uuid = UUID.randomUUID().toString();
    Bootstrap.B stubB = new Bootstrap.B() {
      @Override
      String bar() {
        return uuid;
      }
    };
    Bootstrap.A a = new Bootstrap.A(stubB);
    String actualValue = a.foo();
    Assertions.assertEquals(uuid, actualValue);
  }

}
