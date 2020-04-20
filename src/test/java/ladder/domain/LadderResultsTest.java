package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {
    @Test
    void getResultPosition() {
        Map<Position, Position> results = new HashMap<>();
        results.put(new Position(0), new Position(2));
        results.put(new Position(1), new Position(0));
        results.put(new Position(2), new Position(1));

        LadderResults ladderResults = new LadderResults(results);

        assertThat(ladderResults.getResultPosition(0)).isEqualTo(new Position(2));
        assertThat(ladderResults.getResultPosition(1)).isEqualTo(new Position(0));
        assertThat(ladderResults.getResultPosition(2)).isEqualTo(new Position(1));
    }
}
