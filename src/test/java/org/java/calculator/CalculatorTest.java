package org.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class CalculatorTest {
	
	float x;
	float y;
	Random rnd = new Random();
	
	
	@BeforeEach
	public void randomize() {
		x = rnd.nextFloat(-100f,100f);
		y = rnd.nextFloat(-100f,100f);
	}

	@RepeatedTest(5)
	public void addTest() {
		
		final float res = x + y;
		final float add = Calculator.add(x,y);
		assertEquals(res, add);
		
	}
	
	@RepeatedTest(5)
	public void subtractTest(){
		final float res = x - y;
		final float sub = Calculator.subtract(x,y);
		assertEquals(res, sub);
	}
	
	@RepeatedTest(5)
	public void divideTest(){
		assumeFalse(y == 0);
		final float res = x / y;
		final float sub = Calculator.divide(x,y);
		assertEquals(res, sub);
	}
	
	@RepeatedTest(5)
	public void multiplyTest(){
		final float res = x * y;
		final float sub = Calculator.multiply(x,y);
		assertEquals(res, sub);
	}
	
	@RepeatedTest(5)
	public void subtractPositiveTest() {
		final float res = x - y;
		assumeTrue(res >= 0);
		final float sub = Calculator.subtract(x,y);
		assertEquals(res, sub);
	}
	
	@RepeatedTest(5)
	public void multiplyNegativeTest() {
		assumeTrue(x < 0);
		Calculator.multiply(x,y);
	}
	
	
	
	
}
