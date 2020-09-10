package ladder.domain.reward;

import ladder.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;


class RewardsTest {

    @ParameterizedTest
    @DisplayName("입력 값을 바탕으로 당첨결과 들이 잘 생성 되는지 확인")
    @CsvSource(value = {
            "1000,꽝,2000,꽝=4",
            "꽝,10000000,꽝=3",
            "999=1"
    }, delimiter = '=')
    public void generate_reward_test(String input, int result) {
        // given
        Rewards rewards = Rewards.of(input);

        // when & then
        assertThat(rewards.getCountOfRewards()).isEqualTo(result);
    }


    @Test
    @DisplayName("당첨결과 이름을 잘 가져오는지 확인")
    public void get_reward_name_by_position_test() {
        // given
        String input = "100000,꽝,5000";
        Rewards rewards = Rewards.of(input);

        // when & then
        assertAll(
                () -> assertThat(rewards.getNameByPosition(0)).isEqualTo("100000"),
                () -> assertThat(rewards.getNameByPosition(1)).isEqualTo("꽝"),
                () -> assertThat(rewards.getNameByPosition(2)).isEqualTo("5000")
        );
    }


    @Test
    @DisplayName("위치가 맞지 않는 경우 예외 발생")
    public void get_name_by_position_error_Test() {
        // given
        String input = "꽝,1000,10000";
        Rewards rewards = Rewards.of(input);

        // when & then
        assertThatThrownBy(() -> rewards.getNameByPosition(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨결과가 없습니다. 입력값을 확인해 주세요.");
    }

}
