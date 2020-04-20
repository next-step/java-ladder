package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class PositionTest {
    @Test
    void create() {
        assertThat(new Position(10)).isEqualTo(new Position(10));
        assertThat(new Position(10).toInt()).isEqualTo(10);
    }

    @Test
    void move() {
        Position position = new Position(10);
        assertThat(position.left()).isEqualTo(new Position(9));
        assertThat(position.right()).isEqualTo(new Position(11));
    }

    @Test
    void except() {
        assertThatIllegalStateException().isThrownBy(() -> {
            new Position(-1);
        });

        Position position = new Position(0);
        assertThatIllegalStateException().isThrownBy(() -> {
            position.left();
        });
    }
}
