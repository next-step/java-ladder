package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    void right() {
        Position position = new Position(0, Direction.of(false, true));

        Assertions.assertThat(position.move()).isEqualTo(1);
    }
}
