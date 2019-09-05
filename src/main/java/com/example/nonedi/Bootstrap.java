package com.example.nonedi;

import java.util.UUID;

public class Bootstrap {

  public static void main(String... args) {
    A a = new A();
    String value = a.foo();
    System.out.println(value);
  }

  static class A {
    String foo() {
      B b = new B();
      return b.bar();
    }
  }

  static class B {
    String bar() {
      return UUID.randomUUID().toString();
    }
  }

}
