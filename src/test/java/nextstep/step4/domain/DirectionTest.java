package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Direction 테스트")
class DirectionTest {

    @DisplayName("첫위치의 방향 확인")
    @Test
    void firstPositionDirection() {
        Direction direction = Direction.firstPositionDirection(true);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("두번째 위치 방향 확인")
    @Test
    void next() {
        Direction direction = Direction.firstPositionDirection(true).next(false);
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }

    @DisplayName("마지막 위치 방향 확인")
    @Test
    void last() {
        Direction direction = Direction.firstPositionDirection(false).last();
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();
    }
}
