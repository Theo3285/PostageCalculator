package com.kata;

/**
 * Created by christophe on 11/11/2017.
 */
public class Calculator {

    public Money calculate(int weight, int height, int width, int depth, Currency currency) throws Exception {
        double postageInBaseCurrency = PostageInBaseCurrency(weight, height, width, depth);
        return ConvertCurrency(postageInBaseCurrency, currency);
    }

    private double PostageInBaseCurrency(int weight, int height, int width, int depth) {
        if (weight <= 60 && height <= 229 && width <= 162 && depth <= 25)
        {
            return 120;
        }
        if (weight <= 500 && height <= 324 && width <= 229 && depth <= 100)
        {
            return weight*4;
        }
        return Math.max(weight, height*width*depth/1000)*6;
    }

    private Money ConvertCurrency(double amountInBaseCurrency, Currency currency) throws Exception {
        if (currency == Currency.Gbp)
            return new Money(Currency.Gbp, amountInBaseCurrency);
        if(currency == Currency.Eur)
            return new Money(Currency.Eur, (amountInBaseCurrency + 200) * 1.25);
        if(currency == Currency.Chf)
            return new Money(Currency.Chf, (amountInBaseCurrency + 200) * 1.36);
        throw new Exception("Currency not supported");
    }
}
