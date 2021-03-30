package ladder.entity;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 10, 15, 50, 100, 0x7fffffff})
    void canGenerateHeight(int input) {
        LadderHeight ladderHeight = new LadderHeight(input);
        assertThat(ladderHeight.height()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3, -4, -5, -6, -10, -15, -50, -100, -0x80000000})
    void canThrowExceptionOnNonPositiveInput(int input) {
        CustomException thrown = assertThrows(CustomException.class, () -> new LadderHeight(input));
        assertThat(thrown.errorCode()).isEqualTo(ErrorCode.INVALID_LADDER_HEIGHT);
    }
}
