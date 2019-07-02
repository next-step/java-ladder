package ladder.model;

import ladder.util.RungGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RungGeneratorTest {

    @Test
    void generate() {
        Rung rung = RungGenerator.generate();

        assertThat(rung.isRung()).isTrue();
    }
}
