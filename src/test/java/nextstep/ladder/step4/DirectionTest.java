package nextstep.ladder.step4;

import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }
}
