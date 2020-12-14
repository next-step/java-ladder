package ladder.domain.dto;

import ladder.domain.participant.Position;
import ladder.exception.NotFoundRewardException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void matchRewardTest(int index) {
        //Given
        List<String> rewards = Arrays.asList("꽝", "5000", "꽝", "5000");
        Reward reward = new Reward(rewards);

        //When
        String result = reward.findRewardByPosition(Position.from(index));

        //Then
        assertThat(result).isEqualTo(rewards.get(index));
    }

    @Test
    public void failMatchReward() {
        assertThatThrownBy(() -> {
            List<String> rewards = Arrays.asList("꽝", "5000", "꽝", "5000");
            new Reward(rewards).findRewardByPosition(Position.from(rewards.size() + 1));
        }).isInstanceOf(NotFoundRewardException.class);
    }
}
