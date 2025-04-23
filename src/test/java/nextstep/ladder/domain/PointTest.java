package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    @DisplayName("Point 생성 확인 - true, true - 예외 발생")
    void validTrueTrue() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Point.INVALID_CONNECTION_ERROR);
    }

    @Test
    @DisplayName("Point 이동 확인 - 왼쪽")
    void moveLeft() {
        assertThat(Point.first(true).next(false).move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("Point 이동 확인 - 오른쪽")
    void moveRight() {
        assertThat(Point.first(true).move(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("Point 이동 확인 - 유지")
    void moveStay() {
        assertThat(Point.first(false).last().move(1)).isEqualTo(1);
    }
}
