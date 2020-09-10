package ladder.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void create() {
        Position position = Position.first();

        assertThat(position.getValue()).isEqualTo(0);
    }

    @Test
    void next() {
        Position position = Position.first();
        position = position.next();

        assertThat(position.getValue()).isEqualTo(1);
    }
}
