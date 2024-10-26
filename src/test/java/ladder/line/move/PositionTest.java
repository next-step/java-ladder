package ladder.line.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("사다리 위치가 0보다 작을 경우 예외로 처리한다.")
    @Test
    void create() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Position(-1)
        );
    }

    @DisplayName("위치를 1 증가한 객체를 반환 받을 수 있다.")
    @Test
    void left() {
        assertThat(new Position(1).left())
                .isEqualTo(new Position(2));
    }

    @DisplayName("위치를 1 감소한 객체를 반환 받을 수 있다.")
    @Test
    void right() {
        assertThat(new Position(1).right())
                .isEqualTo(new Position(0));
    }
}
