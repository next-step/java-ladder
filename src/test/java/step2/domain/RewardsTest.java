package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    private Rewards rewards;

    @BeforeEach
    void setUp() {
        rewards = Rewards.of(Arrays.asList("firstPrize", "secondPrize", "꽝"));
    }

    @Test
    @DisplayName("리워드 일급컬렉션이 생성되는지 확인")
    void createPlayers() {
        //given
        assertThat(rewards).isEqualTo(Rewards.of(Arrays.asList("firstPrize", "secondPrize", "꽝")));
    }

    @Test
    @DisplayName("리워드의 리스트가 잘 생성되는지 확인")
    void createPlayersList() {
        //given
        assertThat(rewards.getRewards()).containsExactly(Reward.of("firstPrize"), Reward.of("secondPrize"), Reward.of("꽝"));
    }
}