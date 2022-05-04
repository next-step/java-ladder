package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @Test
    @DisplayName("방향 클래스 생성 테스트")
    void createDirection() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 방향이 둘 다 가능한 Direction 생성 시 예외 처리")
    void invalidDirection() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("맨 왼쪽에 위치한 방향 클래스 생성")
    void createFirstDirection() {
        assertThat(Direction.first(true)).isEqualTo(Direction.of(false, true));
    }

    @Test
    @DisplayName("맨 오른쪽에 위치한 방향 클래스 생성")
    void createLastDirection() {
        Direction firstDirection = Direction.first(true);
        assertThat(firstDirection.last()).isEqualTo(Direction.of(true, false));
    }
}