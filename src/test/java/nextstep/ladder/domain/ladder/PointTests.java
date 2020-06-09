package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PointTests {
    @DisplayName("현재 위치와 Direction을 전달 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Point point = new Point(2, new Direction(false, false));
        assertThat(point).isNotNull();
    }

    @DisplayName("정책에 따라 움직인 뒤 현재 위치를 반환한다.")
    @ParameterizedTest
    @MethodSource("directionAndResult")
    void moveTest(Direction direction, int resultIndex) {
        Point point = new Point(2, direction);
        assertThat(point.move()).isEqualTo(resultIndex);
    }
    public static Stream<Arguments> directionAndResult() {
        return Stream.of(
                Arguments.of(new Direction(true, false), 1),
                Arguments.of(new Direction(false, false), 2),
                Arguments.of(new Direction(false, true), 3)
        );
    }
}
