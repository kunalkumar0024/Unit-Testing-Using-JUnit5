package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Dependency Injection for Constructors and Methods")
public class DependencyInjectionTest {
	
	private static Calculator calc;
	
	public DependencyInjectionTest(TestInfo testInfo) {
		
		System.out.println("Inside constructor");
		
		String displayName = testInfo.getDisplayName();
		assertEquals("DependencyInjectionTest", displayName);
		
	}


	
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
	//@DisplayName("Testing Addition of two positive numbers")
	@Tag(value = "Tag_1")
	void test_Add() {
		
		int actual = calc.add(4, 5);
		
		int expected = 9;
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
	@Disabled("Disabled until cache error will be fixed")
	//@DisplayName("Testing addition of two negative numbers")
	@Tag(value = "Tag_2")
	void test_Add2() {
		
		int actual = calc.add(-4, -5);
		
		int expected = -9;
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
//	@DisplayName("testing addition of one +ve & one -ve number")
	void test_Add3() {
		
		int actual = calc.add(-20, 10);
		
		int expected = -10;
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
//	@DisplayName("Testing subtraction of two positive numbers")
	void test_Sub() {
		
		int actual = calc.sub(700, 456);
		int expected = 244;
		
		assertEquals(expected, actual);
		System.out.println("Testing subtraction of two numbers. Expected is" +expected+" and actual is"+actual);
	}
}
