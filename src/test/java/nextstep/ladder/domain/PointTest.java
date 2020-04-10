package nextstep.ladder.domain;

import nextstep.ladder.domain.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("시작 포인트 생성")
    @Test
    void first() {
        Point first = Point.first();
        assertThat(first.getLinePosition()).isEqualTo(0);
    }

    @DisplayName("중간 포인트 생성")
    @Test
    void middle() {
        Point first = Point.first();
        Point middle = Point.middle(first);

        assertThat(middle.getLinePosition()).isEqualTo(first.getLinePosition() + 1);
        assertThat(middle.getDirection().isLeft()).isEqualTo(first.getDirection().isRight());
    }

    @DisplayName("마지막 포인트 생성")
    @Test
    void last() {
        Point first = Point.first();
        Point middle = Point.middle(first);
        Point last = Point.last(middle);

        assertThat(last.getLinePosition()).isEqualTo(first.getLinePosition() + 2);
        assertThat(last.getDirection().isLeft()).isEqualTo(middle.getDirection().isRight());
        assertThat(last.getDirection().isRight()).isFalse();
    }

    @DisplayName("라인 위치가 음수 일때 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void createFailByNegative(int linePosition) {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.of(linePosition, Direction.of(false, false)));
    }
}