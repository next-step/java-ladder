package ladder.service.impl;

import ladder.model.HorizontalLine;
import ladder.model.LadderLength;
import ladder.model.LineUnit;
import ladder.service.LineGenerator;
import ladder.service.RandomLineGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineGeneratorTest {

    @Test
    void shouldGenerateProperSizeOfLine() {
        LineGenerator generator = new RandomLineGenerator(() -> true);

        List<HorizontalLine> result = generator.generate(2, new LadderLength(5));

        assertThat(result.get(0).size()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    void shouldAlwaysGenerateLine() {
        LineGenerator generator = new RandomLineGenerator(() -> false);

        List<HorizontalLine> result = generator.generate(2, new LadderLength(5));
        List<LineUnit> units = result.get(0).getUnits();

        assertThat(units.get(0).hasNext()).isTrue();
        assertThat(units.get(1).hasPrevious()).isTrue();
    }

    @Test
    void shouldNotAlwaysGenerateLine() {
        LineGenerator generator = new RandomLineGenerator(() -> true);

        List<HorizontalLine> result = generator.generate(2, new LadderLength(5));
        List<LineUnit> units = result.get(0).getUnits();

        assertThat(units.get(0).hasNext()).isFalse();
        assertThat(units.get(1).hasPrevious()).isFalse();
    }

}
