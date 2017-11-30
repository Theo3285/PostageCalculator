package com.kata;

/**
 * Created by christophe on 11/11/2017.
 *
 */
public class Calculator {

    public Money calculate(int weight, int height, int width, int depth, Currency currency) throws Exception {
        Package aPackage = Package.withDimensions(weight, height, width, depth);
        double postageInBaseCurrency = aPackage.postageInBaseCurrency();
        return convertCurrency(postageInBaseCurrency, currency);
    }

    private Money convertCurrency(double amountInBaseCurrency, Currency currency) throws Exception {
        if (currency == Currency.Gbp)
            return new Money(Currency.Gbp, amountInBaseCurrency);
        if(currency == Currency.Eur)
            return new Money(Currency.Eur, (amountInBaseCurrency + 200) * 1.25);
        if(currency == Currency.Chf)
            return new Money(Currency.Chf, (amountInBaseCurrency + 200) * 1.36);
        throw new Exception("Currency not supported");
    }
}
