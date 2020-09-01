package ladder;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.domain.Reward;
import ladder.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"a,b,c", "1,2,3,4,5,6,7,8,9,10"})
    public void rewardTest(String names) {

        Reward reward = new Reward(names);
        String[] nameArray = Arrays.stream(names.split(","))
                                   .map(String::trim)
                                   .toArray(String[]::new);

        List<String> rewards = reward.getNames();
        List<String> rewardsFromRewardStr = StringUtils.splitStringToList(names);

        assertEquals(rewards, rewardsFromRewardStr);

        for (int i = 0; i < rewards.size(); i++) {
            assertEquals(reward.get(i), nameArray[i]);
        }
    }
}
