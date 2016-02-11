package com.talios.bazeltest;

import org.junit.*;
import static org.junit.Assert.*;

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