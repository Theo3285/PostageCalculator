package com.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.kata.Currency.Gbp;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by christophe on 16/11/2017.
 */
@RunWith(Parameterized.class)
public class MediumPackageCalculatorShould {

    Calculator calculator;

    private final int weight;
    private final int height;
    private final int width;
    private final int depth;
    private final String expected;

    public MediumPackageCalculatorShould(int weight, int height, int width, int depth, boolean isValidMoney) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.expected = new Money(Gbp, weight * 4).toString();
    }

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { 61, 1, 1, 1, true},
                new Object[] { 500, 1, 1, 1, true},
                new Object[] { 1, 230, 1, 1, true},
                new Object[] { 1, 324, 1, 1, true},
                new Object[] { 1, 1, 163, 1, true},
                new Object[] { 1, 1, 229, 1, true},
                new Object[] { 1, 1, 1, 26, true},
                new Object[] { 1, 1, 1, 100, true}
        );
    }

    @Before
    public void
    setUp() {
        calculator = new Calculator();
    }

    @Test
    public void
    price_a_medium_package() throws Exception {
        String result = calculator.calculate(weight, height, width, depth, Gbp).toString();
        assertThat(result, is(expected));
    }
}
