package ladder.direction;

import ladder.model.move.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @ParameterizedTest
    @MethodSource("firstParams")
    public void first(boolean trueOrFalse, int result) {
        assertThat(Point.first(trueOrFalse).move()).isEqualTo(result);
    }

    private static Stream<Arguments> firstParams() {
        return Stream.of(
                Arguments.of(false, 0),
                Arguments.of(true, 1)

        );
    }
    @Test
    public void next_stay() {
        Point second = Point.first(false).next(false);
        assertThat(second.move()).isEqualTo(1);
    }

    @Test
    public void next_left() {
        Point second = Point.first(true).next(false);
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    public void next_right() {
        Point second = Point.first(false).next(true);
        assertThat(second.move()).isEqualTo(2);
    }

    @Test
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }
}
