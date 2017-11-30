package com.kata;

/**
 * Created by christophe on 12/11/2017.
 */
public class MediumPackage extends Package {

    private final int weight;

    public MediumPackage(int weight) {
        this.weight = weight;
    }

    @Override
    public double postageInBaseCurrency() {
        return weight*4;
    }
}
