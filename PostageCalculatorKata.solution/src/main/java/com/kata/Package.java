package com.kata;

/**
 * Created by christophe on 12/11/2017.
 *
 */
public abstract class Package {

    public static Package withDimensions(int weight, int height, int width, int depth) {
        if (isSmall(weight, height, width, depth))
        {
            return new SmallPackage();
        }
        if (isMedium(weight, height, width, depth))
        {
            return new MediumPackage(weight);
        }
        return new LargePackage(weight, height, width, depth);
    }

    private static boolean isMedium(int weight, int height, int width, int depth) {
        return weight <= 500 && height <= 324 && width <= 229 && depth <= 100;
    }

    private static boolean isSmall(int weight, int height, int width, int depth) {
        return weight <= 60 && height <= 229 && width <= 162 && depth <= 25;
    }

    abstract double postageInBaseCurrency();
}
