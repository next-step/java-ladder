package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void create() {
        Ladder ladder = Ladder.of(4,5);
        assertThat(ladder.getLadderLines().size()).isEqualTo(5);
    }

    @Test
    void 사다리_모양_검증() {
        Ladder ladder = Ladder.of(4, 5);
        List<Row> rows = ladder.getLadderLines();

        assertThat(IntStream.range(1, rows.size())
            .allMatch(index -> rows.get(index) != rows.get(index - 1)))
            .isTrue();
    }
}
