package ladder.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point 가 CONNECTED 일 경우 isConnect 는 참이다.")
    void connectTrue() {
        assertThat(Point.CONNECTED.isConnect()).isTrue();
    }

    @Test
    @DisplayName("Point 가 DISCONNECTED 일 경우 isConnect 는 거짓이다.")
    void connectFalse() {
        assertThat(Point.DISCONNECTED.isConnect()).isFalse();
    }

    @Test
    @DisplayName("Point 의 true 는 CONNECTED 이다.")
    void valueOfTrue() {
        assertThat(Point.valueOf(true)).isEqualTo(Point.CONNECTED);
    }

    @Test
    @DisplayName("Point 의 false 는 DISCONNECTED 이다.")
    void valueOfFalse() {
        assertThat(Point.valueOf(false)).isEqualTo(Point.DISCONNECTED);
    }
}