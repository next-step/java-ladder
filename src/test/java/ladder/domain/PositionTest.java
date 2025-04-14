package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("0 미만의 위치는 예외 발생")
    @Test
    void createPositionWithNegativeValue() {
        // when & then
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add() {
        // given
        Position position = new Position(1);
        int addValue = 2;

        // when
        Position result = position.add(addValue);

        // then
        Assertions.assertThat(result).isEqualTo(new Position(3));
    }

    @Test
    void subtract() {
        // given
        Position position = new Position(3);
        int subtractValue = 2;

        // when
        Position result = position.subtract(subtractValue);

        // then
        Assertions.assertThat(result).isEqualTo(new Position(1));
    }
}