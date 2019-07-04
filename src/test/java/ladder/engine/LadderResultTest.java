package ladder.engine;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    void put() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.put(1, 2);
        assertThat(ladderResult.getTarget(1)).isEqualTo(2);
    }
}
