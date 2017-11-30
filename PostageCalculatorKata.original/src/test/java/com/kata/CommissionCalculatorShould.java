package com.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.kata.Currency.Chf;
import static com.kata.Currency.Eur;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by christophe on 16/11/2017.
 */
@RunWith(Parameterized.class)
public class CommissionCalculatorShould {


    Calculator calculator;

    private Currency currency;
    private double exchangeRate;
    private String expected;

    public CommissionCalculatorShould(Currency currency, double exchangeRate, boolean isValidMoney) {
        this.currency = currency;
        this.exchangeRate = exchangeRate;
        this.expected = new Money(currency, (120 + 200) * exchangeRate).toString();
    }

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { Eur, 1.25, true},
                new Object[] { Chf, 1.36, true}
        );
    }
    @Before
    public void
    setUp() {
        calculator = new Calculator();
    }

    @Test
    public void
    add_commission_for_currency_other_than_gbp() throws Exception {
        String result = calculator.calculate(20, 20, 20, 20, currency).toString();
        assertThat(result, is(expected));
    }

}
