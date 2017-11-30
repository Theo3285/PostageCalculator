package com.kata;

/**
 * Created by christophe on 11/11/2017.
 */
public class Money {

    private Currency currency;
    private double amount;

    public Money(Currency currencyType, double amount) {
        this.currency = currencyType;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Money{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
