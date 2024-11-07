package ladder.domain.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrossGeneratorTest {
    @Test
    void generate() {
        Boolean actual = ((CrossGenerator) () -> false).generate();

        Assertions.assertThat(actual).isFalse();
    }
}
