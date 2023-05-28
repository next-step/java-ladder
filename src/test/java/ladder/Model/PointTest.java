package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    @DisplayName("왼쪽이 true면 왼쪽으로 이동")
    public void point_move_left() {
        Point point = new Point(true, false);

        Direction expected = Direction.LEFT;
        Direction actual = point.move();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("오른쪽이 true면 오른쪽으로 이동")
    public void point_move_right() {
        Point point = new Point(false, true);

        Direction expected = Direction.RIGHT;
        Direction actual = point.move();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽,오른쪽 모두 false면 아래로 이동")
    public void point_move_down() {
        Point point = new Point(false, false);

        Direction expected = Direction.DOWN;
        Direction actual = point.move();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽,오른쪽 모두 true면 에러발생")
    public void point_move_error() {
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

}