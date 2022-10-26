package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		
		int actual = calc.add(4, 5);
		
		int expected = 9;
		
		assertEquals(expected, actual);
	}

}
