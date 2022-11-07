package com.kunal.testdemo.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepetitionInfo;

public class RepeatedTest {
	
	@org.junit.jupiter.api.RepeatedTest(value = 5)
	void repeatFiveTimes() {
		System.out.println("repeated");
		
	}
	
	
	@org.junit.jupiter.api.RepeatedTest(5)
	void repeatedTestWithRepeatationValue(RepetitionInfo info) {
		
		assertEquals(5, info.getTotalRepetitions());	
		
	}
	
	
	

}
