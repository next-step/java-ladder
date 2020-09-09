package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @DisplayName("LadderResults 생성 테스트")
    @Test
    void createTest() {
        LadderResults results = new LadderResults(Arrays.asList(LadderResult.of("pobi", "꽝")));

        assertThat(results.getLadderResults()).containsExactly(LadderResult.of("pobi", "꽝"));
    }
}