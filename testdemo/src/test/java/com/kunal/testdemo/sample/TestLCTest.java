package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing features of Calculator")
public class TestLCTest {
	
	private static Calculator calc;
	
	@BeforeAll
	static void setUp() {
		calc = new Calculator();
		System.out.println("Testing the program execution. This should execute before all");
	}
	
	@AfterAll
	static void tearDown() {
		calc = null;
		System.out.println("Testing the program execution. This should execute after all other program execution done");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("This will execute before each test case");
	}
	
	@AfterEach
	void afetrEach() {
		System.out.println("This program should run after each test case");
	}
	
	@Test
	@DisplayName("Testing Addition of two positive numbers")
	void testAdd() {
		
		
		int actual = calc.add(4, 5);
		
		int expected = 9;
		
		System.setProperty("ENV","DEV");
		assumeTrue("DEV".equals(System.getProperty("ENV")));
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
	@DisplayName("Testing addition of two negative numbers")
	void testAdd2() {
		
		
		int actual = calc.add(-4, -5);
		
		int expected = -9;
		
		
//assume that it is true if false, it will abort the test.
//		System.setProperty("ENV","DEV");
//		assumeTrue("DEV".equals(System.getProperty("PROD")),TestLCTest::message);
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
	@DisplayName("testing addition of one +ve & one -ve number")
	void testAdd3() {
		
		
		int actual = calc.add(-20, 10);
		
		int expected = -10;

//assume that it is false , if true than abort the test.
//		System.setProperty("ENV","DEV");
//		assumeFalse("DEV".equals(System.getProperty("ENV")),TestLCTest::message);
		
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
	@DisplayName("Testing substraction of two positive numbers")
	void testSub() {
		int actual = calc.sub(700, 456);
		int expected = 244;
		
		assertEquals(expected, actual);
		System.out.println("Testing substraction of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	private static String message() {
		return "Test execution is failed";
	}

}


