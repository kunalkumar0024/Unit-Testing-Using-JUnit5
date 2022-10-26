package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.inOrder;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

//@EnabledOnJre(value = { JRE.JAVA_8,JRE.JAVA_9})
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
//@TestMethodOrder(value = MethodOrderer.Random.class)
//@TestMethodOrder(value = MethodOrderer.Alphanumeric.class)
public class OsConditionalTest {
		
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
		@EnabledOnOs(value = { OS.WINDOWS })
		@EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_16)
		@DisplayName("Testing Addition of two positive numbers")
		@Order(value = 1)
		void testAdd() {
			
			
			int actual = calc.add(4, 5);
			
			int expected = 9;
			
			System.setProperty("ENV","DEV");
			assumeTrue("DEV".equals(System.getProperty("ENV")));
			
			assertEquals(expected, actual);
			System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
		}
		
		@Test
		//@DisabledOnOs(value = { OS.WINDOWS })
		@DisplayName("Testing addition of two negative numbers")
		void testAdd2() {
			
			
			int actual = calc.add(-4, -5);
			
			int expected = -9;
			
			
//assume that it is true if false, it will abort the test.
//			System.setProperty("ENV","DEV");
//			assumeTrue("DEV".equals(System.getProperty("PROD")),TestLCTest::message);
			
			assertEquals(expected, actual);
			System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
		}
		
		@Test
		//@DisabledOnOs(value = { OS.WINDOWS,OS.LINUX })
		//@EnabledIf("customCondition")
		//@DisabledIf("customCondition")
		@DisplayName("testing addition of one +ve & one -ve number")
		@Order(value = 3)
		void testAdd3() {
			
			
			int actual = calc.add(-20, 10);
			
			int expected = -10;

	//assume that it is false , if true than abort the test.
//			System.setProperty("ENV","DEV");
//			assumeFalse("DEV".equals(System.getProperty("ENV")),TestLCTest::message);
			
			
			assertEquals(expected, actual);
			System.out.println("Testing addition of two numbers. Expected is" +expected+" and actual is"+actual);
		}
		
		@Test
		//@EnabledOnOs(value = { OS.WINDOWS,OS.LINUX })
		//@DisabledOnJre(value = {JRE.JAVA_17})
		//@EnabledIfSystemProperty(matches = "Oracle.*", named = "java.vm.vendor")
		//@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
		@Order(value = 2)
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




