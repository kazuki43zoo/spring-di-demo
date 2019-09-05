package com.example.di.constructor;

import java.util.UUID;

public class Bootstrap {

  public static void main(String... args) {
    B b = new B();
    A a = new A(b);
    String value = a.foo();
    System.out.println(value);
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
