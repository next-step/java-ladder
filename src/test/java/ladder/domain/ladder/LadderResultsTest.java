package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @Test
    @DisplayName("실행 결과를 받아 저장할 수 있다.")
    void ladderResultsSaveTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        LadderResults expected = new LadderResults(Arrays.asList("꽝", "5000", "꽝", "3000"));

        // when
        LadderResults results =  LadderResults.of(input);

        // then
        assertThat(results).isEqualTo(expected);
    }

}