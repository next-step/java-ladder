package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RewardsTest {

    private RewardName rewardName1;
    private RewardName rewardName2;
    private RewardName rewardName3;
    private List<RewardName> rewardNames;

    @BeforeEach
    void setUp() {
        rewardName1 = new RewardName("꽝");
        rewardName2 = new RewardName("5000");
        rewardName3 = new RewardName("3000");
        rewardNames = List.of(
                rewardName1,
                rewardName2,
                rewardName1,
                rewardName3
        );
    }

    @Test
    void create() {
        Rewards actual = new Rewards("꽝,5000,꽝,3000");
        Rewards expected = new Rewards(rewardNames);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이름을 출력한다")
    void names() {
        Rewards rewards = new Rewards("꽝,5000,꽝,3000");
        List<RewardName> actual = rewards.names();
        List<RewardName> expected = rewardNames;

        assertThat(actual).isEqualTo(expected);
    }
}
