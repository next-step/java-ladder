package ladder.domain.ns;

import ladder.domain.interfaces.Rewards;
import ladder.domain.wrapper.RewardName;
import ladder.exception.RewardsCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.ns.NsRewards.PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE;
import static ladder.domain.wrapper.RewardNameTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NsRewardsTest {

    public static final String 꽝_5000_꽝_3000 = "꽝,5000,꽝,3000";

    @Test
    @DisplayName("보상을 생성한다")
    void create() {
        List<RewardName> rewardNames = List.of(REWARD_NAME_꽝, REWARD_NAME_5000, REWARD_NAME_꽝, REWARD_NAME_3000);
        Rewards actual = new NsRewards(꽝_5000_꽝_3000, 4);
        Rewards expected = new NsRewards(rewardNames, 4);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("보상을 생성 실패한다: rewardNames 갯수와 playersCount 갯수 불일치")
    void create_실패_rewardNames_갯수와_playersCount_갯수_불일치() {
        assertThatThrownBy(() -> {
            new NsRewards(꽝_5000_꽝_3000, 3);
        }).isInstanceOf(RewardsCountException.class)
                .hasMessage(PLAYERS_COUNT_REWARDS_COUNT_NOT_EQUAL_MESSAGE);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void names() {
        Rewards rewards = new NsRewards(꽝_5000_꽝_3000, 4);
        List<RewardName> actual = rewards.names();
        List<RewardName> expected = List.of(REWARD_NAME_꽝, REWARD_NAME_5000, REWARD_NAME_꽝, REWARD_NAME_3000);

        assertThat(actual).isEqualTo(expected);
    }
}
