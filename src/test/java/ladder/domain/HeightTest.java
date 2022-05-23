package ladder.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @Test
    void over10GetsError() {
        assertThatThrownBy(() -> new Height(11)).isInstanceOf(IllegalArgumentException.class);
    }
}
