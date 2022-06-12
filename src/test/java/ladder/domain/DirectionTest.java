package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DirectionTest {

    @Test
    void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }


    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(IllegalStateException.class);
    }
}