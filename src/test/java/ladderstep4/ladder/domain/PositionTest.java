package ladderstep4.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {
    @Test
    void 포지션_0이상의_수로_생성가능하다_동등성가짐() {
        Assertions.assertThat(new Position(0)).isEqualTo(new Position(0));
    }

    @Test
    void 포지션_생성_음수를_가질수없다() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Position.INVALID_VALUE_MESSAGE);
    }
}
