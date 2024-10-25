package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderPrizesTest {
    @Test
    void 결과들_생성() {
        LadderPrizes ladderResults = new LadderPrizes("test,tt,2");
        assertThat(ladderResults).isNotNull();
    }
}
