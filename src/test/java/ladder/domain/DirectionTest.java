package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @Test
    void direction_creation_test() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);

        Direction direction = Direction.of(true);
        assertThat(direction.getRight()).isFalse();
    }

    @Test
    void next_dircetion_test() {
        Direction direction = Direction.of(false, true);

        Direction next = direction.getNext();

        assertThat(next.getLeft()).isEqualTo(direction.getRight());
    }
}
