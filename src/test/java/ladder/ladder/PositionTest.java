package ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.ladder.Position;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    void 포지션은_0이상() {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 왼쪽_이동() {
        Position position = new Position(1);
        Position result = position.moveLeft();
        assertThat(result).isEqualTo(new Position(0));
    }

    @Test
    void 오른쪽_이동() {
        Position position = new Position(1);
        Position result = position.moveRight();
        assertThat(result).isEqualTo(new Position(2));
    }
}
