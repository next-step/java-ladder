package ladder.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import ladder.ladder.Row;
import ladder.ladder.RowGenerator;
import org.junit.jupiter.api.Test;

class RowGeneratorTest {

    @Test
    void 라인_연속_생성_여부_검증() {
        RowGenerator rowGenerator = new RowGenerator();
        Row row = rowGenerator.create(4);

        assertThat(IntStream.range(1, row.getPoints().size())
            .noneMatch(index -> row.getPoints().get(index) && row.getPoints().get(index - 1)))
            .isTrue();
    }
}
