package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HorizontalPositionTest {

    @Test
    void shouldValidateHorizontalPosition() {
        assertThatThrownBy(() -> new HorizontalPosition(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldIncreasePosition() {
        HorizontalPosition position = new HorizontalPosition(1);

        position.increase();

        assertThat(position).isEqualTo(new HorizontalPosition(2));
    }

    @Test
    void shouldDecreasePosition() {
        HorizontalPosition position = new HorizontalPosition(1);

        position.decrease();

        assertThat(position).isEqualTo(new HorizontalPosition(0));
    }

}
