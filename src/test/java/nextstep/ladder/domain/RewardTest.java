package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardTest {

    private Reward reward = Reward.newInstance("1000");

    @DisplayName("이름이 존재하지 않으면 생성할 수 없다.")
    @ParameterizedTest
    @MethodSource("generateInvalidName")
    void canNotCreateRewardIfNameIsBlank(String name) {
        assertThatThrownBy(() -> Reward.newInstance(name))
                .isInstanceOf(InputValueException.class);
    }

    static Stream<Arguments> generateInvalidName() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of(""),
                Arguments.of(" ")
        );
    }

    @DisplayName("객체를 생성할 수 있다.")
    @Test
    void canCreateReward() {
        assertThat(this.reward).isInstanceOf(Reward.class);
    }

    @DisplayName("보상명을 얻을 수 있다.")
    @Test
    void canToString() {
        assertThat(this.reward.toString()).isEqualTo("1000");
    }
}
