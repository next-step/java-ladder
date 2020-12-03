package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("입력 값을 바탕으로 당첨결과 들이 잘 생성 되는지 확인")
    @CsvSource(value = {
            "1000,꽝,2000,꽝=4",
            "꽝,10000000,꽝=3",
            "999=1"
    }, delimiter = '=')
    void generate_reward_test(String input, int result) {
        // given
        Rewards rewards = Rewards.of(NameSplitter.splitParticipationNames(input));
        // when & then
        assertThat(rewards.getRewardsCount()).isEqualTo(result);
    }

}