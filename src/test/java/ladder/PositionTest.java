package ladder;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PositionTest {
    @Test
    public void next_index() {
        assertThat(new Position(0).next()).isEqualTo(new Position(1));
    }

    @Test
    public void prev_index() {
        assertThat(new Position(1).prev()).isEqualTo(new Position(0));
    }

    @Test
    public void prev_index_invalid_state() {
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> {
            new Position(0).prev();
        });
    }
}
