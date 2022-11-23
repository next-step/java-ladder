package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PointTest {

    @Test
    @DisplayName("0 미만의 값을 할당하는 경우 Point 객체를 생성하는데 실패한다.")
    void create() {
        assertThatThrownBy(() -> new Point(new PositiveInt(-1))).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("0 이상의 값만 입력 가능합니다.");
    }

    @ParameterizedTest
    @MethodSource("generateTestData")
    @DisplayName("move 메소드는 주어진 Direction 객체에 따라 index 값을 변화시킨다.")
    void move(final Direction direction, final Point expected) {
        Point start = new Point(new PositiveInt(3));
        assertThat(start.move(direction)).isEqualTo(expected);
    }

    static Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(Direction.LEFT, new Point(new PositiveInt(2))),
            Arguments.of(Direction.STRAIGHT, new Point(new PositiveInt(3))),
            Arguments.of(Direction.RIGHT, new Point(new PositiveInt(4)))
        );
    }
}