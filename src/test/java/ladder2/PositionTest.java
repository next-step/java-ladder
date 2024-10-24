package ladder2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void first() {
        assertThat(Position.first(true).move()).isEqualTo(1);
        assertThat(Position.first(false).move()).isEqualTo(0);
    }

    @Test
    void next_stay() {
        Position next = Position.first(false).next(false);

        assertThat(next.move()).isEqualTo(1);
    }

    @Test
    void next_left() {
        Position next = Position.first(true).next(false);

        assertThat(next.move()).isEqualTo(0);
    }

    @Test
    void next_right() {
        Position next = Position.first(false).next(true);

        assertThat(next.move()).isEqualTo(2);
    }
}
