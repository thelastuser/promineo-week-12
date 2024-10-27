package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		if (a > 0 && b > 0) {
			return a + b;
		}
		else
		{
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
	}

	public int randomNumberSquared() {
		int r = getRandomInt();
		return r*r;
	}

	public int getRandomInt() {
		Random rand = new Random();
		return rand.nextInt(10)+1;
	}
	
	public String aStringOfLies(int n) {
		// takes an integer n and appends "Lies" n-times to the first "Lie", to form a string of lies
		StringBuilder s = new StringBuilder("Lie");
		for (int i = 0; i < n; i++) {
			s = s.append("Lies");
		}
		return s.toString();
	}
	
}
