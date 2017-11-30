package com.kata;

/**
 * Created by christophe on 12/11/2017.
 */
public class LargePackage extends Package {

    private final int weight;
    private final int height;
    private final int width;
    private final int depth;

    public LargePackage(int weight, int height, int width, int depth) {
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double postageInBaseCurrency() {
        return Math.max(weight, height*width*depth/1000)*6;
    }
}
