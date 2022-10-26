package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
//@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayNameGeneration(value = TestLCTest2.CustomClassDisplayNamegenerator.class)
public class TestLCTest2 {
	
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
	//@DisplayName("Testing Addition of two positive numbers")
	void test_Add() {
		
		
		int actual = calc.add(4, 5);
		
		int expected = 9;
		
		assertEquals(expected, actual);
		System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	@Test
	@Disabled("Disabled until cache error will be fixed")
	//@DisplayName("Testing addition of two negative numbers")
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
//	@DisplayName("Testing substraction of two positive numbers")
	void test_Sub() {
		int actual = calc.sub(700, 456);
		int expected = 244;
		
		assertEquals(expected, actual);
		System.out.println("Testing substraction of two numbers. Expected is" +expected+" and actual is"+actual);
	}
	
	static class CustomClassDisplayNamegenerator extends DisplayNameGenerator.ReplaceUnderscores{

		@Override
		public String generateDisplayNameForClass(Class<?> testClass) {
			// TODO Auto-generated method stub
			//return super.generateDisplayNameForClass(testClass);
			return testClass.getName()+" Test Cases";
		}

		@Override
		public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
			// TODO Auto-generated method stub
			
			return super.generateDisplayNameForNestedClass(nestedClass);
		}

		@Override
		public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
			// TODO Auto-generated method stub
			String name = testClass.getSimpleName()+" "+testMethod.getName();
			return name.replace('_', ' ');
		}
		
	}

}

