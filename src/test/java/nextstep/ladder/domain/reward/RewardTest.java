package nextstep.ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RewardTest {

    @Test
    @DisplayName("네 자릿 수를 초과하면 예외 처리한다.")
    void throwExceptionIfExceedFourDigit() {
        assertThatThrownBy(() -> Reward.of("50000")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수는 허용하지 않는다.")
    void throwExceptionIfNegativeNumber() {
        assertThatThrownBy(() -> Reward.of("-90")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("꽝 또는 정수가 아니면 예외 처리한다.")
    void throwExceptionIfUnsupportedString() {
        assertAll(
            () -> assertThatCode(() -> Reward.of("1000")).doesNotThrowAnyException(),
            () -> assertThatCode(() -> Reward.of("꽝")).doesNotThrowAnyException(),
            () -> assertThatThrownBy(() -> Reward.of("오만원")).isInstanceOf(RuntimeException.class)
        );
    }

}
