package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @DisplayName("라인 위치와 방향을 가지는 포인트 생성")
    @Test
    void create() {
        assertThatCode(() -> Point.of(1, Direction.of(false, false)));
    }

    @DisplayName("방향을 가지지 않는 포인트 이동")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void notMove(int expected) {
        Point point = Point.of(expected, Direction.of(false, false));
        int actual = point.move();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("오른쪽 방향을 가지는 포인트 이동")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void moveRight(int expected) {
        Point point = Point.of(expected, Direction.right(() -> true));
        int actual = point.move();

        assertThat(actual).isEqualTo(expected + 1);
    }

    @DisplayName("왼쪽 방향을 가지는 포인트 이동")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void moveLeft(int expected) {
        Point point = Point.of(expected, Direction.left());
        int actual = point.move();

        assertThat(actual).isEqualTo(expected - 1);
    }
}