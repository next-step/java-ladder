package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderResultsTest {
    @Test
    void 결과들_생성() {
        LadderResults ladderResults = new LadderResults("test,tt,2");
        assertThat(ladderResults).isNotNull();
    }
}
