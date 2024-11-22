package com.leetcode.solutions.classes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.BDDAssertions.then;

public class ParkingSystemTest {

    public static Stream<Arguments> ParkingSystemTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0}, new int[]{1, 2, 3, 1}, Arrays.asList(null, true, true, false, false)),
                Arguments.of(new int[]{2, 2, 0}, new int[]{1, 2, 3, 1}, Arrays.asList(null, true, true, false, true)),
                Arguments.of(new int[]{2, 2, 1}, new int[]{1, 2, 3, 1, 2, 3}, Arrays.asList(null, true, true, true, true, true, false))
        );
    }

    @ParameterizedTest
    @MethodSource("ParkingSystemTestCases")
    public void testParkingSystem(int[] parkingLot, int[] cars, List<Boolean> expectedResult) {
        // given
        var actual = new ArrayList<Boolean>();
        actual.add(null);
        final var serviceUnderTest = new ParkingSystem(parkingLot[0], parkingLot[1], parkingLot[2]);

        // when
        for (int car : cars) {
            actual.add(serviceUnderTest.addCar(car));
        }

        // then
        then(actual).isEqualTo(expectedResult);
    }
}
