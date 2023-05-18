package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RewardTest {

    @ParameterizedTest(name = "경품 생성 {0}")
    @ValueSource(strings = {"1", "10000", "꽝"})
    public void create_경품(String input) {
        Reward ladderReward = new Reward(input);
        assertThat(ladderReward.reward()).isEqualTo(input);
    }

    @DisplayName("리워드 형식이 아닐 시 오류")
    @Test
    public void create_오류_경품() {
        assertThatThrownBy(() -> new Reward("test_1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
