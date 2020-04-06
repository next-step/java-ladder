package ladder;

import ladder.model.LadderPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderPrizeTest {
    @DisplayName("꽝을 입력하면 정상 수행")
    @ParameterizedTest
    @ValueSource(strings = {"꽝"})
    void createTest(String input) {
        assertThatCode(() -> new LadderPrize(input)).doesNotThrowAnyException();
    }

    @DisplayName("꽝이 아닌 글자를 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"글자", "이것은 글자"})
    void throwExceptionWhenItsNameAreNotBlank(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderPrize(input);
        });
    }

    @DisplayName("0보다 작은 숫자를 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-10000"})
    void throwExceptionWhenItsNameAreNotNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderPrize(input);
        });
    }
}