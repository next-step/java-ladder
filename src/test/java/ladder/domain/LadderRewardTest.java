package ladder.domain;


import ladder.LadderUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderRewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    void ladderRewardTest(String input) {
        List<String> rewards = LadderUtil.splitStringByComma(input);
        int userCount = 4;

        Reward reward = Reward.of(rewards, userCount);

        assertThat(reward.toList()).containsAnyOf(rewards.toArray());
    }


    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    void ladderRewardTest(String input) {
        List<String> rewards = LadderUtil.splitStringByComma(input);
        int userCount = 1;

        assertThatExceptionOfType(unmatchRewardCountException.class).isThrownBy(() -> {
            Reward.of(rewards, userCount);
        });
    }
}
