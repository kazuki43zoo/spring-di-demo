package com.example.spring.componentscan;

import java.util.UUID;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

public class Bootstrap {

  public static void main(String... args) {
    try (ConfigurableApplicationContext context =
             new AnnotationConfigApplicationContext(MyConfig.class)) {
      A a = context.getBean(A.class);
      String value = a.foo();
      System.out.println(value);
    }
  }

  @ComponentScan
  static class MyConfig {
  }

  @Component
  static class A {
    private final B b;

    A(B b) {
      this.b = b;
    }

    String foo() {
      return b.bar();
    }
  }

  @Component
  static class B {
    String bar() {
      return UUID.randomUUID().toString();
    }
  }

}
