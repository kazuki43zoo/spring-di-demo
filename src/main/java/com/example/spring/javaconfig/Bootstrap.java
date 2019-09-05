package com.example.spring.javaconfig;

import java.util.UUID;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Bootstrap {

  public static void main(String... args) {
    try (ConfigurableApplicationContext context =
             new AnnotationConfigApplicationContext(MyConfig.class)) {
      A a = context.getBean(A.class);
      String value = a.foo();
      System.out.println(value);
    }
  }

  static class MyConfig {
    @Bean
    B b() {
      return new B();
    }

    @Bean
    A a(B b) {
      return new A(b);
    }
  }

  static class A {
    private final B b;

    A(B b) {
      this.b = b;
    }

    String foo() {
      return b.bar();
    }
  }

  static class B {
    String bar() {
      return UUID.randomUUID().toString();
    }
  }

}
