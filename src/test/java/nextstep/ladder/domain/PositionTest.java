package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("현재 위치가 음수가 되면 예외를 발생시킨다.")
    @Test
    void 현재위치가_음수일떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Position(-1);
        });
    }

    @DisplayName("사다리의 이전의 길이 존재하면 포지션은 하나 감소한다.")
    @Test
    void 사다리_이전으로_이동() {
        final Position position = new Position(1);
        assertThat(position.move(Direction.LEFT)).isEqualTo(new Position(0));
    }

    @DisplayName("사다리의 이후의 길이 존재하면 포지션은 하나 증가한다.")
    @Test
    void 사다리_이후으로_이동() {
        final Position position = new Position(1);
        assertThat(position.move(Direction.RIGHT)).isEqualTo(new Position(2));
    }

    @DisplayName("사다리의 이전, 이후의 길이 존재하지 않으면 포지션은 그대로 유지한다.")
    @Test
    void 사다리_이동안함() {
        final Position position = new Position(1);
        assertThat(position.move(Direction.PASS)).isEqualTo(new Position(1));
    }
}