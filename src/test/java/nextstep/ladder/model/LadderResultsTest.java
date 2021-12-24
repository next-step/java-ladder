package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsTest {
    public static final LadderResults FOUR_LADDER_RESULTS = LadderResults.from(Arrays.asList("꽝", "1000", "2000", "꽝"));

    @Test
    void fromTest() {
        // when & then
        assertThat(FOUR_LADDER_RESULTS).isNotNull();
    }
}
