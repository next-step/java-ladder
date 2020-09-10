package step2.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeLocationTest {
    private static Stream<Arguments> createPrizeLocationMember() {
        return Stream.of(
                Arguments.of("Fail,5000,Fail,3000", 2, "Fail"),
                Arguments.of("Fail,5000,Fail,3000", 3, "3000"),
                Arguments.of("1000,20000,3000,60000", 1, "20000")
        );
    }

    @ParameterizedTest
    @MethodSource("createPrizeLocationMember")
    void create_PrizeLocation_Collection_Test(String value, int position, String expected) {
        PrizeLocation prizeLocation = PrizeLocation.of(value.split(","));
        assertThat(prizeLocation.getPrizeIntoLocation(position)).isEqualTo(expected);

    }
}
