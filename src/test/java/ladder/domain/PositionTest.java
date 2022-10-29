package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void shouldValidateHorizontalPosition() {
        assertThatThrownBy(() -> new Position(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldIncreasePosition() {
        Position position = new Position(1);

        position.increase();

        assertThat(position).isEqualTo(new Position(2));
    }

    @Test
    void shouldDecreasePosition() {
        Position position = new Position(1);

        position.decrease();

        assertThat(position).isEqualTo(new Position(0));
    }

}
