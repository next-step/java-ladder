package camp.nextstep.edu.rebellion.domain.reward;

import camp.nextstep.edu.rebellion.domain.reward.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {
    @DisplayName("입력 값을 바탕으로 당첨결과 들이 잘 생성 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1000,꽝,2000,꽝:4",
            "떡볶이,순대,튀김:3",
            "꽝:1"
    }, delimiter = ':')
    public void rewardTest(String input, int expected) {
        // given
        Rewards rewards = new Rewards(input);

        // when & then
        assertThat(rewards.getCountOfRewards())
                .isEqualTo(expected);
    }

    @DisplayName("위치에 맞는 당첨결과 이름을 잘 가져오는지 확인")
    @Test
    public void findNameByPositionTest() {
        // given
        String input = "떡볶이,순대,튀김";
        Rewards rewards = new Rewards(input);

        // when & then
        assertAll(
                () -> assertThat(rewards.findNameByPosition(0)).isEqualTo("떡볶이"),
                () -> assertThat(rewards.findNameByPosition(1)).isEqualTo("순대"),
                () -> assertThat(rewards.findNameByPosition(2)).isEqualTo("튀김")
        );
    }

    @DisplayName("위치가 맞지 않는 경우 예외 발생")
    @Test
    public void findNameByPositionThrownTest() {
        // given
        String input = "떡볶이,순대,튀김";
        Rewards rewards = new Rewards(input);

        // when & then
        assertThatThrownBy(() -> rewards.findNameByPosition(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨결과가 없습니다 입력값을 확인해 주세요");
    }
}
