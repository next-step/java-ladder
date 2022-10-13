package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @DisplayName("하나의 점은 위치와 사용 가능 여부 상태를 가진다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void point(boolean input) {
        assertThat(new Point(1, input)).isEqualTo(new Point(1, input));
    }

    @DisplayName("위치가 1 미만인 경우 예외가 발생한다.")
    @Test
    void pointException() {
        assertThatThrownBy(() -> new Point(0, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용 가능 상태를 정의할 수 있다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void pointStrategy(boolean input) {
        assertThat(Point.of(1, () -> input)).isEqualTo(new Point(1, input));
    }

    @DisplayName("점끼리 연결될 수 있다.")
    @Test
    void connect() {
        Point pointA = new Point(1, true);
        Point pointB = new Point(2, true);

        assertThat(pointA.isConnected(pointB)).isTrue();
    }

    @DisplayName("옆에 있는 점이어도 활성화된 점이 아니면 연결될 수 없다.")
    @Test
    void connectTrue() {
        Point pointA = new Point(1, true);
        Point pointB = new Point(2, false);

        assertThat(pointA.isConnected(pointB)).isFalse();
    }

    @DisplayName("활성화된 점이어도 떨어져 있으면 연결되어있다고 판단하지 않는다.")
    @Test
    void connectFalse() {
        Point pointA = new Point(1, true);
        Point pointB = new Point(3, true);

        assertThat(pointA.isConnected(pointB)).isFalse();
    }
}
