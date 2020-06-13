package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private List<Direction> points;

    @BeforeEach
    void setup() {
        // Line =>     |-----|    |
        points = new ArrayList<>();
        points.add(new Direction(false, true));
        points.add(new Direction(true, false));
        points.add(new Direction(false, false));
    }

    @ParameterizedTest
    @MethodSource("provideLocation")
    @DisplayName("옆에 다리 있을 경우 이동")
    void move(int location, int expected) {
        Line line = new Line(points);

        int result = line.move(location);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLocation() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 2)
        );
    }
}
