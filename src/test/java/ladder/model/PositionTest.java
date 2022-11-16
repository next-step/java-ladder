package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("앞으로 갈 경우 위치가 1증가한다.")
    @Test
    void goNext() {
        Position position = new Position(0);
        assertThat(position.goNext()).isEqualTo(new Position(1));
    }

    @DisplayName("뒤로 갈 경우 위치가 1감소한다.")
    @Test
    void goBack() {
        Position position = new Position(1);
        assertThat(position.goBack()).isEqualTo(new Position(0));
    }

    @DisplayName("위치가 음수이면 예외가 발생한다.")
    @Test
    void validatePosition() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
