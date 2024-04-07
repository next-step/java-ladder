package nextstep.ladder.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoveDirectionTest {

    @Test
    void Move는_현재_위치에서_오른쪽으로_이동할_경우_currentIndex값이_증가한다() {
        MoveDirection direction = MoveDirection.RIGHT;
        Assertions.assertThat(direction.move(3)).isEqualTo(4);
    }

    @Test
    void Move는_현재_위치에서_왼쪽으로_이동할_경우_currentIndex값이_감소한다() {
        MoveDirection direction = MoveDirection.LEFT;
        Assertions.assertThat(direction.move(3)).isEqualTo(2);
    }

    @Test
    void Move는_현재_위치에서_이동하지_않을_경우_currentIndex값은_그대로이다() {
        MoveDirection direction = MoveDirection.NO_MOVE;
        Assertions.assertThat(direction.move(3)).isEqualTo(3);
    }
}
