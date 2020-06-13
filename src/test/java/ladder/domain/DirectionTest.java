package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    private final Direction direction = new Direction(true, false);

    @Test
    void isLeft() {
        boolean result = direction.isLeft();
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isRight() {
        boolean result = direction.isRight();
        assertThat(result).isEqualTo(false);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0"})
    void goLeft(int nowLocation, int nextLocation) {
        int result = direction.goLeft(nowLocation);
        assertThat(result).isEqualTo(nextLocation);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2"})
    void goRight(int nowLocation, int nextLocation) {
        int result = direction.goRight(nowLocation);
        assertThat(result).isEqualTo(nextLocation);
    }
}
