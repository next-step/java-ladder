package ladder.domain.result;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @Test
    void create() {
        LadderResults results = new LadderResults(Arrays.asList(LadderResult.of("pobi", "꽝")));

        assertThat(results.getLadderResults()).containsExactly(LadderResult.of("pobi", "꽝"));
    }
}