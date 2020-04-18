package ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderRewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    void ladderRewardTest(String input) {
        int userCount = 4;
        String[] expected = input.split(",");

        Reward reward = Reward.of(input, userCount);

        assertThat(reward.toList()).containsAnyOf(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    void unmatchRewardCountExceptionTest(String input) {
        int userCount = 1;

        assertThatExceptionOfType(UnmatchRewardCountException.class).isThrownBy(() -> {
            Reward.of(input, userCount);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝,5000,꽝,3000"})
    void prizeByEachPositionTest(String input) {
        int userCount = 4;
        String[] expected = input.split(",");

        Reward reward = Reward.of(input, userCount);

        assertThat(reward.prizeByEachPosition(0)).containsAnyOf(expected[0]);
    }
}
