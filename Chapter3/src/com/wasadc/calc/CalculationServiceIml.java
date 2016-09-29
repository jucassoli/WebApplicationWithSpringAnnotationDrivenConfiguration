/**
 * 
 */
package com.wasadc.calc;

/**
 * @author Juliano Cassoli
 *
 */
public class CalculationServiceIml implements CalculationService {

	/* (non-Javadoc)
	 * @see com.wasadc.calc.CalculateService#sum(int, int)
	 */
	@Override
	public int sum(int a, int b) {
		return a + b;
	}

}
