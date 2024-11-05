package ladder.study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void random() {
        assertThat(Math.random()).isBetween(0d, 1d);
    }
}
