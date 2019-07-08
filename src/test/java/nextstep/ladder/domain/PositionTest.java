package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @Test
    @DisplayName("첫번째 position 이 잘 생성되는지")
    void first() {
        final int size = 5;
        final Position actual = Position.first(5);
        assertThat(actual).isInstanceOf(Position.class);
    }

    @Test
    @DisplayName("다음 position 을 잘 생성하는지")
    void increase() {
        final Position position = Position.first(1);
        final Position actual = position.increase();
        assertThat(actual).isInstanceOf(Position.class);
    }

    @Test
    @DisplayName("다음 position 이 범위를 벗어나는 경우 예외 발생")
    void increase_outOfRange_exception() {
        final Position last = Position.first(2).increase();
        assertThatIllegalArgumentException().isThrownBy(
                last::increase
        );
    }
}