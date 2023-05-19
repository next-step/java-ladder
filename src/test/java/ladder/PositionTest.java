package ladder;

import ladder.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("위치가 음수인 경우 예외가 발생한다")
    @Test
    void isPositive() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Position(-1));
    }

    @DisplayName("현재 위치의 오른쪽 위치인지 확인한다")
    @Test
    void validateRight() {
        Position position = new Position(0);
        Position nextPosition = new Position(1);

        assertThat(position.validateRight(nextPosition)).isTrue();
    }
}
