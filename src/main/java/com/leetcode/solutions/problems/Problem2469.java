package com.leetcode.solutions.problems;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem2469 {

    public double[] convertTemperature(double input) {
        final var kelvin = input + 273.15;
        final var fahrenheit = input * 1.80 + 32.00;
        return new double[]{
                roundToDecimalPlaces(kelvin, 5),
                roundToDecimalPlaces(fahrenheit, 5)
        };
    }

    private double roundToDecimalPlaces(double value, int decimalPlaces) {
        return BigDecimal
                .valueOf(value)
                .setScale(decimalPlaces, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
