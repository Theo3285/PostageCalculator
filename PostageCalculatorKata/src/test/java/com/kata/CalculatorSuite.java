package com.kata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by christophe on 16/11/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SmallPackageCalculatorShould.class,
        MediumPackageCalculatorShould.class,
        LargeHeavyPackageCalculatorShould.class,
        LargeLightPackageCalculatorShould.class,
        CommissionCalculatorShould.class
})

public class CalculatorSuite {
}
