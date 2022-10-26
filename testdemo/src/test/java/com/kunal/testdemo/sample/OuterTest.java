package com.kunal.testdemo.sample;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

public class OuterTest {
	
	@BeforeAll
	static void setUp() {
		System.out.println("(Outer)=>Testing the program execution. This should execute before all");
	}
	
	@AfterAll
	static void tearDown() {
		System.out.println("(Outer)=>Testing the program execution. This should execute after all other program execution done");
	}
	
	@Test
	void outerTest1() {
		
	}
	
	@Test
	void outerTest2() {
		
	}
	
	@Nested
	@TestInstance(value = Lifecycle.PER_CLASS)
	class InnerTest{
		
		@BeforeAll
		void setUp() {
			System.out.println("(Inner)=>Testing the program execution. This should execute before all");
		}
		
		@AfterAll
		void tearDown() {
			System.out.println("(Inner)=>Testing the program execution. This should execute after all other program execution done");
		}
		
		@Test
		void innerTest1() {
			
		}
		
		@Test
		void innertTest2() {
			
		}
		
		@Test
		void innerTest3() {
			
		}
	}

}
