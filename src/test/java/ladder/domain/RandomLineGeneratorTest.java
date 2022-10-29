package ladder.domain;

import ladder.dto.LineGenerateDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineGeneratorTest {

    @Test
    void shouldGenerateProperSizeOfLine() {
        RandomLineGenerator generator = new RandomLineGenerator(() -> true);

        List<HorizontalLine> result = generator.generate(new LineGenerateDto(2, 5));

        assertThat(result.get(0).size()).isEqualTo(2);
        assertThat(result.size()).isEqualTo(5);
    }

    @Test
    void shouldAlwaysGenerateLine() {
        RandomLineGenerator generator = new RandomLineGenerator(() -> false);

        List<HorizontalLine> result = generator.generate(new LineGenerateDto(2, 5));
        List<Direction> units = result.get(0).getUnits();

        assertThat(units.get(0).hasNext()).isTrue();
        assertThat(units.get(1).hasPrevious()).isTrue();
    }

    @Test
    void shouldNotAlwaysGenerateLine() {
        RandomLineGenerator generator = new RandomLineGenerator(() -> true);

        List<HorizontalLine> result = generator.generate(new LineGenerateDto(2, 5));
        List<Direction> units = result.get(0).getUnits();

        assertThat(units.get(0).hasNext()).isFalse();
        assertThat(units.get(1).hasPrevious()).isFalse();
    }

}
