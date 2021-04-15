package nextstep.refactoring.laddergame.engine.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RewardStringTest {

    @Test
    @DisplayName("꽝 또는 숫자가 아니면 예외 처리한다.")
    void throwExceptionIfStringIsNotNumberOrSpecialBlackString() {
        assertAll(
            () -> assertThatThrownBy(() -> RewardString.of("tdd")).isInstanceOf(IllegalArgumentException.class),
            () -> assertDoesNotThrow(() -> RewardString.of("1000")),
            () -> assertDoesNotThrow(() -> RewardString.of("꽝"))
        );
    }
    
}
