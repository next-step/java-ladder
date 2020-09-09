package ladder.domain.reward;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RewardsTest {

    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = Rewards.ofPrizes("꽝,5000,꽝,3000", 4);
    }

    @Test
    void create() {
        List<Reward> expectReward = Arrays.asList(Reward.of("꽝"), Reward.of("5000"), Reward.of("꽝"), Reward.of("3000"));
        assertThat(rewards)
                .isEqualTo(Rewards.of(expectReward, 4));
    }

    @Test
    void createByString() {
        assertThat(rewards).isEqualTo(Rewards.ofPrizes("꽝,5000,꽝,3000", 4));
    }

    @Test
    void create_invalidCount() {
        assertThatThrownBy(() -> Rewards.ofPrizes("꽝,5000,꽝,3000", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0,꽝", "1,5000", "2,꽝", "3,3000"})
    void findPrize(int index, String reward) {
        assertThat(rewards.findReward(index).getName()).isEqualTo(reward);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5})
    void findPrize_invalidIndex(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> rewards.findReward(input));
    }
}
