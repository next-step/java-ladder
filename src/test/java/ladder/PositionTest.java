package ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void 왼쪽아래로_이동() {
        Position position = new Position(2, 2);
        assertThat(position.moveLeftAndDown()).isEqualTo(new Position(3, 1));
    }

    @Test
    void 오른쪽아래로_이동() {
        Position position = new Position(2, 2);
        assertThat(position.moveRightAndDown()).isEqualTo(new Position(3, 3));
    }

    @Test
    void 아래로_이동() {
        Position position = new Position(2, 2);
        assertThat(position.moveDown()).isEqualTo(new Position(3, 2));
    }
}
