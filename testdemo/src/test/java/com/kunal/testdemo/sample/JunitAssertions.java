package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class JunitAssertions {
	
	@Test
	void assertTrueTest() {
		assertTrue(10 > 6, "10 is greater than 6");
		
		assertTrue(10 > 6, ()->"10 is greater than 6");
	}
	
	@Test
	void assertFalseTest() {
		BooleanSupplier condition = ()->10<6;
		assertFalse(condition,"10 is not smaller than 6");
	}

	@Test
	void assertEqualTest() {
		MyUtils util = new MyUtils();
		
		int actual = util.add(12, 2);
		int expected = 14;
		assertEquals(expected,actual);
	}
	
	@Test
	void assertEqualTest2() {
		float square = 4*4;
		float rectangle = 5*4;
		float delta = 4;
		
		assertEquals(square, rectangle,delta);
	}
	
	@Test
	void asserNotEqualsTest() {
		int actual = 100;
		
		assertNotEquals(10,actual,"Should not be equal to 100");
	}

	@Test
	void assertNotNullTest() {
	
		Object ob = new Object();
		
		//Object obj = null;
		
		assertNotNull(ob,()->"This object should not be null");
	}
	
	@Test
	void assertNullTest() {
		Object ob = null;
		
		//Object obj = new Object();
		assertNull(ob,()->"this b=object should be null");
	}
	
	@Test
	void assertSameTest() {
		String name = "Kunal";
		Optional<String> optional = Optional.of(name);
		assertSame(name,optional.get());
	}
	
	@Test
	void assertNotSameTest() {
		String subject = "Java";
		Optional<String> opt = Optional.of(subject);
		
		subject = "C++";
		assertNotSame(subject,opt.get());
	}
	
	@Test
	void assertArrayEqualsTest() {
		char[] expected = {'j','a','v','a'};
		
		char[] actual = "java".toCharArray();
		
		assertArrayEquals(expected,actual,"Both array should be equal");
	}
	
	@Test
	void assertAllTest() {
		Employee emp = new Employee("Kunal", "Singh");
		
		assertAll("employeeInfo",()->assertNotNull(emp.getFirstName(),()->"Ferst name should not be null"),
				()->assertNotNull("singh",emp.getLastName().toLowerCase()));
	}
	
	@Test
	void assertThrowsTest() {
		Throwable exception = assertThrows(
				IllegalArgumentException.class, ()->{ throw new IllegalArgumentException("Exception message");} );
		
		assertEquals("Exception message", exception.getMessage());
	}
	
	@Test
	void assertDoesNotThrowsTest() {
		//String input = "Kunal";
		String input = "25.24E+8";
		
		assertDoesNotThrow(()->Double.parseDouble(input),"String not able to parse into double");
	}
	
	@Test
	public void assertIterableEqualsTest() {
	Iterable<String> list1 = new ArrayList<>(Arrays.asList("Kunal","Prince"));
	Iterable<String> list2 = new LinkedList<>(Arrays.asList("Kunal","Prince"));
	
	assertIterableEquals(list1,list2);
	}
	
	
	@Test
	void assertTimeoutTest() {
		assertTimeout(
				Duration.ofMillis(500), 
				()->{ Thread.sleep(400);
				});
	}
	
	@Test
	void assertTimeoutPreemtivelyTest() {
		assertTimeoutPreemptively(
				Duration.ofMillis(500), 
				()->{Thread.sleep(400);
		        
				return "final result";
				});
		
	}
	
	@Test
	void assertLinesMatchTest() {
		List<String> expected = Arrays.asList("Kunal","\\d+","Java");
		List<String> actual = Arrays.asList("Kunal","24","Java");
		
		assertLinesMatch(expected,actual);
	}
	
	@Test
	@Disabled
	void failTest() {
		fail("Test has not completed yet");
	}
	
}
