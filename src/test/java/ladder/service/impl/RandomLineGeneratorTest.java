package ladder.service.impl;

import ladder.model.HorizontalLine;
import ladder.service.LineGenerator;
import ladder.service.RandomLineGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineGeneratorTest {

    @Test
    void shouldGenerateProperSizeOfLine() {
        LineGenerator generator = new RandomLineGenerator();

        List<HorizontalLine> result = generator.generate(2, 5);

        assertThat(result.get(0).size()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(5);
    }

}
