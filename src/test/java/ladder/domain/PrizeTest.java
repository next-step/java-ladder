package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PrizeTest {
    @Test
    public void create() {
        assertThatCode(() -> new Prize("꽝"))
                .doesNotThrowAnyException();
    }
}