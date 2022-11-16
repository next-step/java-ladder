package nextstep.game;

import game.domain.ladder.Direction;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {
    @Test
    @Order(0)
    public void 왼쪽_오른쪽_둘다_설정() {
        assertThatThrownBy(
                () -> Direction.of(true, true)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("왼쪽/오른쪽 한 방향으로만 설정해주세요.");
    }

    @Test
    @Order(1)
    public void 왼쪽_이동() {
        assertThat(Direction.of(true, false).move()).isEqualTo(-1);
    }

    @Test
    @Order(2)
    public void 오른쪽_이동() {
        assertThat(Direction.of(false, true).move()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void 사다리방향_생성() {
        assertThatNoException().isThrownBy(() -> Direction.next(true, true));
    }
}
