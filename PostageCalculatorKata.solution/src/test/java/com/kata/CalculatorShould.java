package com.kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static com.kata.Currency.Chf;
import static com.kata.Currency.Eur;
import static com.kata.Currency.Gbp;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by christophe on 11/11/2017.
 */
public class CalculatorShould {

    private int MaximumSmallWeight = 60;
    Calculator calculator;
    private double SmallPackagePrice = 120;
    private int MaximumSmallHeight = 229;
    private int MaximumSmallWidth = 162;
    private int MaximumSmallDepth = 25;
    private int MaximumMediumWeight = 500;
    private int MaximumMediumHeight = 324;
    private int MaximumMediumWidth = 229;
    private int MaximumMediumDepth = 100;
    private double GbpToEur = 1.25;
    private double GbpToChf = 1.36;
    private double Commission = 200;

    @Before
    public void
    setUp() {
        calculator = new Calculator();

    }

    @Test
    public void
    charge_a_flat_rate_for_a_small_package_with_maximal_small_weight() throws Exception {
        Money expected = new Money(Gbp, SmallPackagePrice);
        Money result = calculator.calculate(MaximumSmallWeight, 1, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    charge_a_flat_rate_for_a_small_package_with_maximal_small_height() throws Exception {
        Money expected = new Money(Gbp, SmallPackagePrice);
        Money result = calculator.calculate(1, MaximumSmallHeight, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    charge_a_flat_rate_for_a_small_package_with_maximal_small_width() throws Exception {
        Money expected = new Money(Gbp, SmallPackagePrice);
        Money result = calculator.calculate(1, 1, MaximumSmallWidth, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    charge_a_flat_rate_for_a_small_package_with_maximal_small_depth() throws Exception {
        Money expected = new Money(Gbp, SmallPackagePrice);
        Money result = calculator.calculate(1, 1, 1, MaximumSmallDepth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_small_weight_plus_one() throws Exception {
        int weight = MaximumSmallWeight + 1;
        Money expected = new Money(Gbp, weight * 4);
        Money result = calculator.calculate(weight, 1, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_medium_weight() throws Exception {
        Money expected = new Money(Gbp, MaximumMediumWeight * 4);
        Money result = calculator.calculate(MaximumMediumWeight, 1, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_small_height_plus_one() throws Exception {
        int height = MaximumSmallHeight + 1;
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, height, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_medium_height() throws Exception {
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, MaximumMediumHeight, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_small_width_plus_one() throws Exception {
        int width = MaximumSmallWidth + 1;
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, 1, width, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_medium_width() throws Exception {
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, 1, MaximumMediumWidth, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_small_depth_plus_one() throws Exception {
        int depth = MaximumSmallDepth + 1;
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, 1, 1, depth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_medium_package_with_maximal_medium_depth() throws Exception {
        Money expected = new Money(Gbp, 1 * 4);
        Money result = calculator.calculate(1, 1, 1, MaximumMediumDepth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_heavy_package_with_maximal_medium_weight_plus_one() throws Exception {
        int weight = MaximumMediumWeight + 1;
        Money expected = new Money(Gbp, weight * 6);
        Money result = calculator.calculate(weight, 1, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_heavy_package_with_maximal_medium_height_plus_one() throws Exception {
        int height = MaximumMediumHeight + 1;
        Money expected = new Money(Gbp, 1 * 6);
        Money result = calculator.calculate(1, height, 1, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_heavy_package_with_maximal_medium_width_plus_one() throws Exception {
        int width = MaximumMediumWidth + 1;
        Money expected = new Money(Gbp, 1 * 6);
        Money result = calculator.calculate(1, 1, width, 1, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_heavy_package_with_maximal_medium_depth_plus_one() throws Exception {
        int depth = MaximumMediumDepth + 1;
        Money expected = new Money(Gbp, 1 * 6);
        Money result = calculator.calculate(1, 1, 1, depth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_light_package_with_high_height_volume() throws Exception {
        int weight = 1;
        int height = 1001;
        int width = 1;
        int depth = 1;
        Money expected = new Money(Gbp, (height * width * depth/1000)*6);
        Money result = calculator.calculate(weight, height, width, depth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_light_package_with_high_width_volume() throws Exception {
        int weight = 1;
        int height = 1;
        int width = 1001;
        int depth = 1;
        Money expected = new Money(Gbp, (height * width * depth/1000)*6);
        Money result = calculator.calculate(weight, height, width, depth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    price_a_large_light_package_with_high_depth_volume() throws Exception {
        int weight = 1;
        int height = 1;
        int width = 1;
        int depth = 1001;
        Money expected = new Money(Gbp, (height * width * depth/1000)*6);
        Money result = calculator.calculate(weight, height, width, depth, Gbp);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    add_commission_for_euro_currency() throws Exception {
        Money expected = new Money(Eur, (SmallPackagePrice + Commission) * GbpToEur);
        Money result = calculator.calculate(20, 20, 20, 20, Eur);
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void
    add_commission_for_chf_currency() throws Exception {
        Money expected = new Money(Chf, (SmallPackagePrice + Commission) * GbpToChf);
        Money result = calculator.calculate(20, 20, 20, 20, Chf);
        assertThat(result.toString(), is(expected.toString()));
    }
}
