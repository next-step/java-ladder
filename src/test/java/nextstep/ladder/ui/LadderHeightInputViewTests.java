package nextstep.ladder.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightInputViewTests {
    @DisplayName("최대 사다리 높이가 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = { -1, -3, 0 })
    void createValidationTest(int invalidLadderHeight) {
        assertThatThrownBy(() -> new LadderHeightInputView(invalidLadderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
