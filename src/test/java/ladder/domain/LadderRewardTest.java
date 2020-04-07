package ladder.domain;

import ladder.exception.ExceptionType;
import ladder.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderRewardTest {
    @Test
    void ladderReward() {
        new LadderReward("100,꽝,10억", 3 );
    }

    @Test
    void ladderReward_exception() {
        assertThatThrownBy(() -> new LadderReward("100,꽝,10억", 4 ))
                .isInstanceOfAny(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_RESULT_SIZE.getErrorMessage());
    }

    @Test
    void getReward() {
        LadderReward reward = new LadderReward("100,꽝,10억", 3 );

        String actual = reward.getReward(2);

        assertThat(actual).isEqualTo("10억");
    }
}
