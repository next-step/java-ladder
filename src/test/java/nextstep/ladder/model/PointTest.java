package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("포인트")
class PointTest {

    @Test
    @DisplayName("정적 팩토리 메소드로 생성")
    void instance() {
        assertThatNoException().isThrownBy(Point::connected);
        assertThatNoException().isThrownBy(Point::disconnected);
    }

    @Test
    @DisplayName("연결 여부")
    void isConnected() {
        assertThat(Point.connected().isConnected()).isTrue();
        assertThat(Point.disconnected().isConnected()).isFalse();
    }
}
