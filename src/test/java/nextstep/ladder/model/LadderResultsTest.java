package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @Test
    void fromTest() {
        // given
        List<String> ladderResults = Arrays.asList("꽝", "1000", "2000");
        // when & then
        assertThat(LadderResults.from(ladderResults)).isNotNull();
    }
}
