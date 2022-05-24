package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @Test
    void over20GetsError() {
        assertThatThrownBy(() -> new Height(21)).isInstanceOf(IllegalArgumentException.class);
    }
}
