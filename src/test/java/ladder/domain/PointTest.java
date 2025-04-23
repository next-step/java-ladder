package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("첫번 째 사다리 가로대를 생성한다.")
    void createFirstPoint() {
        assertThat(Point.create(() -> true)).isEqualTo(new Point(0, false, true));
        assertThat(Point.create(() -> false)).isEqualTo(new Point(0, false, false));
    }

    @Test
    @DisplayName("이전 사다리 가로대가 없으면 정책에 따라서 생성한다.")
    void createNextWithNonPrevious() {
        assertThat(Point.create(() -> true).createNext(() -> true)).isEqualTo(new Point(1, true, false));
        assertThat(Point.create(() -> true).createNext(() -> false)).isEqualTo(new Point(1, true, false));
        assertThat(Point.create(() -> false).createNext(() -> true)).isEqualTo(new Point(1, false, true));
        assertThat(Point.create(() -> false).createNext(() -> false)).isEqualTo(new Point(1, false, false));
    }

    @Test
    @DisplayName("마지막 사다리 가로대를 생성한다.")
    void createLastPoint() {
        assertThat(new Point(0, false, true).createLast()).isEqualTo(new Point(1, true, false));
        assertThat(new Point(0, false, false).createLast()).isEqualTo(new Point(1, false, false));
    }

    @Test
    @DisplayName("사다리 가로대를 통해 움직인다.")
    void isConnected() {
        assertThat(new Point(0, false, true).move()).isEqualTo(1);
        assertThat(new Point(1, true, false).move()).isEqualTo(0);
        assertThat(new Point(2, false, false).move()).isEqualTo(2);
    }
}
