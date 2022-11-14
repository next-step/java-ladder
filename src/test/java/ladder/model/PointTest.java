package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("위치가 오른쪽으로 이동한다.")
    @Test
    void moveRight() {
        Point point = new Point(0, new Direction(false, true));
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("위치가 왼쪽으로 이동한다.")
    @Test
    void moveLeft() {
        Point point = new Point(1, new Direction(true, false));
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("위치가 아래로 이동한다.")
    @Test
    void moveDown() {
        Point point = new Point(1, new Direction(false, false));
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("위치가 음수이면 예외가 발생한다.")
    @Test
    void validatePosition() {
        assertThatThrownBy(() -> {
            new Point(-1, new Direction(false, false));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
