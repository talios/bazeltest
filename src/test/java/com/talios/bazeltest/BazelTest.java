package com.talios.bazeltest;

import static org.junit.Assert.*;

import org.junit.*;

public class BazelTest {

  @Test
  public void testSomething() {
    System.out.println("....testing.");
  }

  @Test
  public void testSomethingElse() {
    assertEquals("booleans are equal", true, true);
  }
}
