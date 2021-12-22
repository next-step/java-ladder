package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    @Test
    void 방향예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.first(true).next(true))
                .withMessage("한 라인에 두 방향으로 이동할 수 없습니다.");
    }

    @Test
    void left() {
        Direction direction = Direction.first(true).next(false);
        assertThat(direction.isLeft()).isTrue();
    }

    @Test
    void right() {
        Direction direction = Direction.first(false).next(true);
        assertThat(direction.isRight()).isTrue();
    }

    @Test
    void down() {
        Direction direction = Direction.first(false).next(false);
        assertThat(direction.isDown()).isTrue();
    }

}
