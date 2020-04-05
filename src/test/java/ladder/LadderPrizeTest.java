package ladder;

import ladder.model.LadderPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderPrizeTest {
    @DisplayName("꽝이 아닌 글자를 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"글자", "이것은 글자"})
    void throwExceptionWhenItsNameAreNotBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderPrize(input);
        });
    }

    @DisplayName("양수가 아닌 숫자를 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-10000"})
    void throwExceptionWhenItsNameAreNotNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderPrize(input);
        });
    }
}