package ladder.strategy;

import ladder.domain.ladder.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointRandomStrategyTest {
    @ParameterizedTest
    @MethodSource("countOfUserAndResult")
    @DisplayName("random 값이 항상 true를 반환 시, true가 연속되어 나타날 수 없다.")
    void step_exception(int countOfTotal, List<Point> expectedList) {
        PointStrategy pointStrategy = new PointRandomStrategy(countOfTotal, new RandomReturnTrue());

        expectedList.forEach(expected -> assertThat(pointStrategy.nextPoint()).isEqualTo(expected));
    }

    static Stream<Arguments> countOfUserAndResult() {
        return Stream.of(
                arguments(2, Arrays.asList(Point.of(false, true), Point.of(true, false))),
                arguments(3, Arrays.asList(Point.of(false, true), Point.of(true, false), Point.of(false, false))));
    }

    private static class RandomReturnTrue extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }
}