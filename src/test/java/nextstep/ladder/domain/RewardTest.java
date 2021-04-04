package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RewardTest {

    @Test
    @DisplayName("네 자릿 수를 초과하면 예외 처리한다.")
    void throwExceptionIfExceedFourDigit() {
        assertThatThrownBy(() -> new Reward("50000")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수는 허용하지 않는다.")
    void throwExceptionIfNegativeNumber() {
        assertThatThrownBy(() -> new Reward("-90")).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("꽝 또는 정수가 아니면 예외 처리한다.")
    void throwExceptionIfUnsupportedString() {
        assertAll(
            () -> assertThatCode(() -> new Reward("1000")).doesNotThrowAnyException(),
            () -> assertThatCode(() -> new Reward("꽝")).doesNotThrowAnyException(),
            () -> assertThatThrownBy(() -> new Reward("오만원")).isInstanceOf(RuntimeException.class)
        );
    }

}
