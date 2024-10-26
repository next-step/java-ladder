package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @DisplayName("사다리 가장 왼쪽에서 처음 이동 시 오른쪽으로 이동할 수 있는 객체를 생성할 수 있다.")
    @Test
    void first() {
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("사다리의 마지막으로 이동 시 다음으로 이동할 수 없는 객체를 생성할 수 있다.")
    @Test
    void last() {
        Point point = Point.first(true).last();
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @DisplayName("다음 사다리 연결 상태를 객체로 만들 수 있다.")
    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("사다리 왼쪽으로 이동할 수 있다.")
    @Test
    void left() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("사다리 오른쪽으로 이동할 수 있다.")
    @Test
    void right() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("왼쪽 또는 오른쪽으로 갈 수 없는 경우 움직이지 않는다.")
    @Test
    void pass() {
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @DisplayName("왼쪽 또는 오른쪽 모두로 갈 수 있는 경우 방향을 결정할 수 없기 때문에 예외로 처리한다.")
    @Test
    void invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> Point.first(true).next(true));
    }
}
