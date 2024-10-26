package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @DisplayName("현재 위치에서 오른쪽으로 이동하면 현재 위치가 1 증가한다.")
    @Test
    void right() {
        Point right = Point.first(true);

        Cross cross = new Cross(new Position(1), right);

        assertThat(cross.move()).isEqualTo(new Position(2));
    }

    @DisplayName("현재 위치에서 왼쪽으로 이동하면 현재 위치가 1 감소한다.")
    @Test
    void left() {
        Point left = Point.first(true).next(false);

        Cross cross = new Cross(new Position(1), left);

        assertThat(cross.move()).isEqualTo(new Position(0));
    }

    @DisplayName("현재 위치에서 이동할 수 없는 경우 현재 위치는 변하지 않는다.")
    @Test
    void pass() {
        Point pass = Point.first(false).next(false);

        Cross cross = new Cross(new Position(1), pass);

        assertThat(cross.move()).isEqualTo(new Position(1));
    }
}
