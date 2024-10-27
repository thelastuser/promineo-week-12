package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;
	

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@CsvSource({"1,1,2,false", "9,9,18,false", "50,50,100,true"})
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		expectException = false;
		
		if (!expectException) {
			assertThat(testDemo.addPositive(1, 2)).isEqualTo(3);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(5, 4)==(9));
		assertThat(testDemo.addPositive(15, 4)==(19));
		assertThat(testDemo.addPositive(19, 16)==(35));
		assertThat(testDemo.addPositive(10, 1000)==(1010));
		assertThat(testDemo.addPositive(51, 2)==(53));
		
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	@Test
	void assertThatAStringOfLiesIsCorrect() {
		// a single test of aStringOfLies using an input of 5 to append the string "Lies" 5 times after the word "Lie"
		assertThat(testDemo.aStringOfLies(5)=="LieLiesLiesLiesLiesLies");
	}

}
