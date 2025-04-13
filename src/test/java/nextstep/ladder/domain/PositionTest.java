package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void createTest() {
        Position position = new Position(1);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("value must be greater than or equal to 0");
    }
}
