package ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void 왼쪽아래로_이동() {
        Position position = new Position(2, 2);
        position.moveLeftAndDown();
        assertThat(position).isEqualTo(new Position(3, 1));
    }

    @Test
    void 오른쪽아래로_이동() {
        Position position = new Position(2, 2);
        position.moveRightAndDown();
        assertThat(position).isEqualTo(new Position(3, 3));
    }

    @Test
    void 아래로_이동() {
        Position position = new Position(2, 2);
        position.moveDown();
        assertThat(position).isEqualTo(new Position(3, 2));
    }
}
