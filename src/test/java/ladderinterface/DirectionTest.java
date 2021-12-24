package ladderinterface;

import ladderinterface.concrete.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    @DisplayName("라인이 겹치면 예외 : 이전 점과 현재 점이 true, true")
    @Test
    void 라인겹침예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.first(true).next(true))
                .withMessage("라인이 겹치지 않아야 합니다.");
    }

    @DisplayName("첫번째 점은 이전 점이 무조건 false")
    @Test
    void first() {
        Direction direction = Direction.first(true);
        assertThat(direction).isEqualTo(Direction.of(false, true));
    }

    @DisplayName("마지막 점은 현재 점이 무조건 false")
    @Test
    void last() {
        Direction direction = Direction.first(true).last();
        assertThat(direction).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("왼쪽 방향으로 가려면 이전 점이 true, 현재 점이 false")
    @Test
    void left() {
        Direction direction = Direction.first(true).next(false);
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("오른쪽 방향으로 가려면 이전 점이 false, 현재 점이 true")
    @Test
    void right() {
        Direction direction = Direction.first(false).next(true);
        assertThat(direction.isRight()).isTrue();
    }

    @DisplayName("아래 방향으로 가려면 이전 점이 false, 현재 점이 false")
    @Test
    void down() {
        Direction direction = Direction.first(false).next(false);
        assertThat(direction.isDown()).isTrue();
    }

}
