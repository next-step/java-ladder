package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RewardTest {
    @DisplayName("보상 객체 생성 테스트")
    @Test
    void create_생성테스트() {
        // given
        Reward reward = Reward.valueOf("꽝");
        // when
        Reward expected = Reward.valueOf("꽝");
        // then
        assertThat(reward).isEqualTo(expected);
    }

    @DisplayName("보상 객체 생성 예외 테스트")
    @ParameterizedTest(name = "`{0}` 값 입력 테스트")
    @NullAndEmptySource
    void create_예외테스트(String given) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Reward.valueOf(given));

    }
}
