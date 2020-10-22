package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리타기 결과를 제공한다")
    void ladderResultTest() {
        String userRaw = "a,bb,ccc,dd";
        String resultRaw = "ar,bbr,cccr,ddr";

        Ladder ladder = Ladder.random(userRaw, resultRaw, 5);
        Rewards rewards = ladder.getRewards();

        assertThat(rewards.getRewards()).extracting("reward")
                .containsExactly("ar", "bbr", "cccr", "ddr");
    }

}