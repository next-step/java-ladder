package step4;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    public void init() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @Test
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
