package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    @Test
    void over20GetsError() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(21));
    }

    @Test
    void equalsCanCompareHeights() {
        assertThat(new Height(5)).isEqualTo(new Height(5));
    }
}
