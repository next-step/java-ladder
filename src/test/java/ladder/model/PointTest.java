package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointTest {

    @Test
    @DisplayName("한 방향만 입력하면 객체를 생성한다")
    void of() {
        assertThat(Point.of(true, false)).isInstanceOf(Point.class);
    }

    @ParameterizedTest
    @MethodSource("moveProvider")
    @DisplayName("방향에 따라 인덱스가 좌우로 이동한다")
    void move(Point point, int currentIndex, int expectedIndex) {
        assertThat(point.move(currentIndex)).isEqualTo(expectedIndex);
    }

    public static Stream<Arguments> moveProvider() {
        return Stream.of(
                arguments(Point.of(true, false), 1, 0),
                arguments(Point.of(false, true), 1, 2),
                arguments(Point.of(false, false), 1, 1)
        );
    }

}