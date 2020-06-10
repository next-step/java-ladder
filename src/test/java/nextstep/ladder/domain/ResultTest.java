package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    private Result result = initialize();

    @DisplayName("결과가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateResultIfResultIsNull() {
        assertThatThrownBy(() -> Result.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 객체를 생성할 수 있다.")
    @Test
    void canCreateResult() {
        assertThat(this.result).isInstanceOf(Result.class);
    }

    @DisplayName("Map을 얻을 수 있다.")
    @Test
    void canToMap() {
        assertThat(this.result.toMap()).isInstanceOf(Map.class);
    }

    @DisplayName("사용자에 대한 보상을 얻을 수 있다.")
    @ParameterizedTest
    @MethodSource("generatePlayerAndReward")
    void canGetRewardForPlayer(Player player, Reward reward) {
        assertThat(this.result.get(player)).isEqualTo(reward);
    }

    static Stream<Arguments> generatePlayerAndReward() {
        return Stream.of(
                Arguments.of(Player.newInstance("A", 0), Reward.newInstance("1000")),
                Arguments.of(Player.newInstance("B", 0), Reward.newInstance("2000")),
                Arguments.of(Player.newInstance("C", 0), Reward.newInstance("3000"))
        );
    }

    Result initialize() {
        Map<Player, Reward> result = new HashMap<>();
        result.put(Player.newInstance("A", 0), Reward.newInstance("1000"));
        result.put(Player.newInstance("B", 0), Reward.newInstance("2000"));
        result.put(Player.newInstance("C", 0), Reward.newInstance("3000"));

        return Result.newInstance(result);
    }
}
