package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void left() {
        Direction direction = new Direction(true, false);

        assertThat(direction.move()).isEqualTo(-1);
    }
}
