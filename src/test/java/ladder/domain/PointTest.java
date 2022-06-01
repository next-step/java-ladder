package ladder.domain;

import ladder.exception.ContinuousConnectionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    private Point leftConnectedPoint;
    private Point rightConnectedPoint;

    @BeforeEach
    void setup() {
        leftConnectedPoint = Point.of(true, false);
        rightConnectedPoint = Point.of(false, true);
    }

    @Test
    @DisplayName("Point 가 양쪽 다 CONNECTED 일 경우 ContinuousConnectionException 를 반환한다.")
    void continuousConnected() {
        assertThatThrownBy(() -> Point.of(true, true))
                .isInstanceOf(ContinuousConnectionException.class)
                .hasMessage("사다리 라인은 연속으로 연결될 수 없습니다.");
    }

    @Test
    @DisplayName("다음 Point 가 생성될 때 현재 Point 오른쪽과 다음 Point 왼쪽 값이 둘다 Connected 일 경우 ContinuousConnectionException 를 반환한다.")
    void continuousConnected_next() {
        assertThatThrownBy(() -> rightConnectedPoint.next(true))
                .isInstanceOf(ContinuousConnectionException.class)
                .hasMessage("사다리 라인은 연속으로 연결될 수 없습니다.");
    }

    @Test
    @DisplayName("첫번째 Point 가 생성될 때 왼쪽 값은 항상 Disconnected 이다")
    void first() {
        assertThat(Point.first(true)).isEqualTo(Point.of(false, true));
        assertThat(Point.first(false)).isEqualTo(Point.of(false, false));
    }

    @Test
    @DisplayName("마지막 Point 가 생성될 때 오른쪽 값은 항상 Disconnected 이다")
    void last() {
        assertThat(Point.first(true).last()).isEqualTo(Point.of(true, false));
        assertThat(Point.first(false).last()).isEqualTo(Point.of(false, false));
    }

    @Test
    @DisplayName("다음 Point 가 생성될 때 다음 Point 왼쪽은 현재 Point 오른쪽과 동일하다.")
    void next() {
        assertThat(Point.of(true, false).next(true)).isEqualTo(Point.of(false, true));
        assertThat(Point.of(false, true).next(false)).isEqualTo(Point.of(true, false));
    }

    @Test
    @DisplayName("왼쪽으로 연결되어 있으면 true 를 반환한다.")
    void isLeftConnected() {
        assertThat(leftConnectedPoint.isLeftConnected()).isTrue();
        assertThat(rightConnectedPoint.isLeftConnected()).isFalse();
    }

    @Test
    @DisplayName("오른쪽으로 연결되어 있으면 true 를 반환한다.")
    void isRightConnected() {
        assertThat(leftConnectedPoint.isRightConnected()).isFalse();
        assertThat(rightConnectedPoint.isRightConnected()).isTrue();
    }
}