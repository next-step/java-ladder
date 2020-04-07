package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    @DisplayName("높이가 0 보다 작을 때 Exception 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -3, -10})
    void exceptByCreation(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Height.of(input);
        }).withMessage(String.format("높이는 0보다 큰 정수여야 합니다.(%d)", input));
    }
}