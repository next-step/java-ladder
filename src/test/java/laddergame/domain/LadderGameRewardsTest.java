package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderGameRewardsTest {

    private final LadderGameRewards rewards = new LadderGameRewards(List.of(new LadderGameReward("꽝"), new LadderGameReward("당첨")));

    @DisplayName("문자열의 사다리 게임 보상 목록을 전달하면, 인스턴스가 생성되어야 한다.")
    @Test
    void from() {
        assertThat(LadderGameRewards.from(List.of("꽝", "당첨"))).isEqualTo(rewards);
    }

    @DisplayName("인덱스를 전달하면, 해당 인덱스의 사다리 게임 보상을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,꽝",
            "1,당첨"
    })
    void get(int index, String expectedValue) {
        assertThat(rewards.get(index)).isEqualTo(new LadderGameReward(expectedValue));
    }

    @DisplayName("범위를 벗어나는 인덱스를 전달하면, 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    void get_givenIndexOutOfRange(int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> rewards.get(index));
    }

}
