package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Direction 테스트")
class DirectionTest {

    @DisplayName("Direction 생성 확인")
    @Test
    void direction() {
        Direction direction = Direction.firstPositionDirection(true);
        assertThat(direction).isInstanceOf(Direction.class);
    }

    @DisplayName("첫위치의 방향 확인")
    @Test
    void firstPositionDirection() {
        Direction direction = Direction.firstPositionDirection(true);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isTrue();

        direction = Direction.firstPositionDirection(false);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();
    }

    @DisplayName("두번째 위치 방향 확인")
    @Test
    void next() {
        Direction direction = Direction.firstPositionDirection(true).next(false);
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();

        direction = Direction.firstPositionDirection(true).next(true);
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();

        direction = Direction.firstPositionDirection(false).next(false);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();

        direction = Direction.firstPositionDirection(false).next(true);
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("마지막 위치 방향 확인")
    @Test
    void last() {
        Direction direction = Direction.firstPositionDirection(false).last();
        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();

        direction = Direction.firstPositionDirection(true).last();
        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }
}
