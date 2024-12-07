package ladder.domain.interfaces.generator;

import ladder.domain.interfaces.generator.CrossGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrossGeneratorTest {
    @Test
    void generate() {
        Boolean actual = ((CrossGenerator) () -> false).generate();

        Assertions.assertThat(actual).isFalse();
    }
}
