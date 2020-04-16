package ladder.domain.result;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LadderResultsTest {

    @Test
    void ladderResultCreateTest() {
        String input ="꽝, 3000, 5000, 꽝";
        LadderResults ladderResults = new LadderResults(input);
        assertThat(ladderResults.showLadderResults()).containsExactly(
                new LadderResult("꽝"),
                new LadderResult("3000"),
                new LadderResult("5000"),
                new LadderResult("꽝")
        );
        assertThat(ladderResults.showResult(2)).isEqualTo("5000");
    }
}
