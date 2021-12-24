package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {
    private static final List<String> LADDER_RESULTS = Arrays.asList("꽝", "1000", "2000", "3000");
    public static final LadderResults FOUR_LADDER_RESULTS = LadderResults.from(LADDER_RESULTS);

    @Test
    void fromTest() {
        // when & then
        assertThat(FOUR_LADDER_RESULTS).isNotNull();
    }

    @Test
    void getTest() {
        // when & then
        assertThat(FOUR_LADDER_RESULTS.get(0)).isEqualTo(LadderResultTest.BANG);
    }

    @Test
    void sizeTest() {
        // when & then
        assertThat(FOUR_LADDER_RESULTS.size()).isEqualTo(LADDER_RESULTS.size());
    }
}
