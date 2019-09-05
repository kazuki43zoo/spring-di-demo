package com.example.di.setter;

import java.util.UUID;

public class Bootstrap {

  public static void main(String... args) {
    A a = new A();
    String value = a.foo();
    System.out.println(value);
  }

  static class A {
    private B b = new B();

    void setB(B b) {
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
