package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void direction_creation_test() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);

        Direction direction = Direction.of(true);
        assertThat(direction.getRight()).isFalse();
    }
}
