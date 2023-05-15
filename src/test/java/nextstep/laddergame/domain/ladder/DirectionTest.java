package nextstep.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        final Direction direction = Direction.first(true).next(false);
        assertThat(direction)
                .isInstanceOf(Direction.class);
    }

    @Test
    @DisplayName("사다리가 좌우 동시에 연결하려할 경우 오른쪽 사다리 연결안함.")
    void checkDuplicateDirection() {
        assertThat(Direction.first(true).next(true).move())
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리 왼쪽으로 이동하는 기능 확인")
    void moveLeft() {
        final Direction direction = Direction.first(true).next(false);

        assertThat(direction.move())
                .isEqualTo(-1);
    }

    @Test
    @DisplayName("사다리 오른쪽으로 이동하는 기능 확인")
    void moveRight() {
        final Direction direction = Direction.first(false).next(true);

        assertThat(direction.move())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("사다리 좌우로 이동하지 않는 기능 확인")
    void movePass() {
        final Direction direction = Direction.first(false).next(false);

        assertThat(direction.move())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("사다리 유무 확인")
    void isLeftDirection() {
        final Direction direction = Direction.first(true);

        assertThat(direction.isLeftDirection())
                .isFalse();
    }
}
