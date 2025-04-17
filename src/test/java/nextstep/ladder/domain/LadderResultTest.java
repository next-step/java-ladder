package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderResultTest {
    @Test
    void createTest() {
        LadderResult ladderResult = new LadderResult("3000");

        assertThat(ladderResult).isEqualTo(new LadderResult("3000"));
    }

    @Test
    void getValueTest() {
        LadderResult ladderResult = new LadderResult("3000");

        assertThat(ladderResult.getReward()).isEqualTo("3000");
    }
}
