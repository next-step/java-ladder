package ladder.domain.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HorizontalGeneratorTest {
    @Test
    void generate() {
        Boolean actual = ((HorizontalGenerator) () -> false).generate();

        Assertions.assertThat(actual).isFalse();
    }
}
