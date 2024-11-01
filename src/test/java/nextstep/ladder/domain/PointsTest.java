package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointsTest {

    @DisplayName("Points 생성 시 연결된 Point없이 잘 생성되는지")
    @Test
    void createPointsTest() {
        Points points = Points.of(3);
        for (int i = 0; i < 3; i++) {
            assertThat(points.isConnected(i)).isFalse();
        }
    }

    @DisplayName("Points의 연결 메서드를 통해 연결이 잘 동작하는지")
    @Test
    void connectTest() {
        Points points = Points.of(3);
        points.connect(1);
        assertThat(points.isConnected(0)).isFalse();
        assertThat(points.isConnected(1)).isTrue();
        assertThat(points.isConnected(2)).isFalse();
    }

    @DisplayName("유효하지 않은 위치에 연결을 시도한 경우 예외가 잘 발생하는지")
    @Test
    void connectInvalidPositionTest() {
        Points points = Points.of(3);
        assertThatIllegalArgumentException().isThrownBy(() -> points.connect(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> points.connect(3));
    }

    @DisplayName("Points의 주위 position 연결 여부를 확인하는 메서드가 잘 동작하는지")
    @Test
    void hasAdjacentConnectionTest() {
        Points points = Points.of(4);
        points.connect(1);

        assertThat(points.hasAdjacentConnection(0)).isTrue();
        assertThat(points.hasAdjacentConnection(1)).isFalse();
        assertThat(points.hasAdjacentConnection(2)).isTrue();
        assertThat(points.hasAdjacentConnection(3)).isFalse();
    }
}
