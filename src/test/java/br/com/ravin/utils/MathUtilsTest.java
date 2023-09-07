package br.com.ravin.utils;



import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.devxlabs.ravin.utils.MathUtils;

@RunWith(SpringRunner.class)
public class MathUtilsTest {
	
	public static MathUtils mt;
	
	@BeforeClass 
	public static void setUp() {
		mt = new MathUtils();
	}
	@Test
	public void sum_shouldSumTwoNumber() {
		//Arrange
		float numberA = 10.0f;
		float numberB = 5.0f;
		float numberC =3.0f;
		//ACT
		float result = mt.sum(numberA, numberB,numberC);
		//Assert
		assertEquals(18, result,0);
	}
	@Test(expected = ArithmeticException.class)
	public void divide() {
		int numberA = 10;
		int numberB = 0;
	
		assertThrows(ArithmeticException.class, ()->mt.divide(numberA, numberB));
	}
}
