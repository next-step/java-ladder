package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @Test
    public void create() {
        Position p = Position.of(0);
        assertThat(p).isEqualTo(Position.of(0));
        assertThat(p == Position.of(0)).isTrue();
    }

    @Test
    public void create_over_max() {
        Position p = Position.of(Integer.MAX_VALUE);
        assertThat(p == Position.of(Integer.MAX_VALUE)).isTrue();
    }

    @Test
    public void invalid_position() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Position.of(-1);
        });
    }
}
